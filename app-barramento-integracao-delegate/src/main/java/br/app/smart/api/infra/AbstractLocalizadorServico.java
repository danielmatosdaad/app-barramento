package br.app.smart.api.infra;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.app.barramento.integracao.dto.LocalizadorServico;

public abstract class AbstractLocalizadorServico<S> implements LocalizadorServico<S> {

	private static final String JNDI_PROPERTIES = "jndi.properties";
	protected String registroNomeLocal;
	protected String registroNomeRemote;
	protected String nomeArquivoPropriedadeLocalizacao;
	protected TipoLocalizador tipoLocalizacao;

	public AbstractLocalizadorServico(TipoLocalizador tipoLocalizacao, String registroNomeLocal,
			String registroNomeRemote, String nomeArquivoPropriedade) {
		super();
		this.tipoLocalizacao = tipoLocalizacao;
		this.registroNomeLocal = registroNomeLocal;
		this.registroNomeRemote = registroNomeRemote;
		this.nomeArquivoPropriedadeLocalizacao = nomeArquivoPropriedade;
	}

	public S getServico() {
		Properties prop = null;
		try {

			// primeiro busca em variaveis de ambientes, caso nao ache, procurar
			// por jndi properites
			// properties

			prop = criarPropriedadesLocal();
			if (prop == null) {
				prop = criarPropriedadesDoAmbiente();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			prop = criarPropriedadesDefault();
		}

		try {
			Context context = new InitialContext(prop);
			S servico = (S) context.lookup(localizar());
			return servico;
		} catch (NamingException e) {
			e.printStackTrace();

			try {
				Context ctx = new InitialContext();
				S servico = (S) ctx.lookup(localizar());
				return servico;
			} catch (NamingException e1) {
				e1.printStackTrace();
			}

		}

		return null;
	}

	protected Properties criarPropriedadesLocal() throws IOException {
		try {
			Properties prop = new Properties();
			InputStream is = this.getClass().getResourceAsStream(JNDI_PROPERTIES);
			prop.load(is);
			return prop;
		} catch (Exception e) {
			System.out.println("nao foi possivel achar a proriedade jndi properties");
			throw new RuntimeException(e);

		}
		
	}

	protected boolean isVazio(String valor) {

		if (valor == null || valor.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	protected Properties criarPropriedadesDoAmbiente() {
		String INITIAL_CONTEXT_FACTORY = System.getProperty("java.naming.factory.initial");
		String PROVIDER_URL = System.getProperty("java.naming.provider.url");
		String SECURITY_PRINCIPAL = System.getProperty("java.naming.security.principal");
		String SECURITY_CREDENTIALS = System.getProperty("java.naming.security.credentials");
		String NAMIN_CLIENT = System.getProperty("jboss.naming.client.ejb.context");
		String URL_PKG_PREFIXES = System.getProperty("org.jboss.ejb.client.naming");
		if (isVazio(INITIAL_CONTEXT_FACTORY) || isVazio(PROVIDER_URL) || isVazio(SECURITY_PRINCIPAL)
				|| isVazio(SECURITY_CREDENTIALS) || isVazio(NAMIN_CLIENT) || isVazio(URL_PKG_PREFIXES)) {
			return null;
		}

		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		prop.put(Context.PROVIDER_URL, PROVIDER_URL);
		prop.put(Context.SECURITY_PRINCIPAL, SECURITY_PRINCIPAL);
		prop.put(Context.SECURITY_CREDENTIALS, SECURITY_CREDENTIALS);
		prop.put(Context.URL_PKG_PREFIXES, URL_PKG_PREFIXES);
		return prop;
	}

	protected Properties criarPropriedadesDefault() {
		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		prop.put(Context.SECURITY_PRINCIPAL, "admin");
		prop.put(Context.SECURITY_CREDENTIALS, "Daad161931[");
		prop.put("jboss.naming.client.ejb.context", false);

		return prop;
	}

	public String localizar() {

		String registroNome = "";
		if (this.tipoLocalizacao.equals(TipoLocalizador.LOCAL)) {
			registroNome = this.registroNomeLocal;
			
		} else {
			registroNome = this.registroNomeRemote;
		}
		System.out.println(registroNome);
		String localizacao = System.getProperty(registroNome);
		try {

			if (localizacao == null) {
				Properties propriedades = new Properties();
				InputStream is = this.getClass().getResourceAsStream(nomeArquivoPropriedadeLocalizacao);

				propriedades.load(is);
				localizacao = (String) propriedades.get(registroNome);

			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao localizar o servico", e);
		}

		return localizacao;
	}
}
