package br.app.corporativo.integracao.api;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.IServiceIntegracao;
import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoIntegracao<T extends IServiceIntegracao> extends AbstractLocalizadorServico<T> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.servico.integracao";
	private static final String REGISTRO_NOME_REMOTO = "remoto.servico.integracao";
	private String repositorio, catalogo, ip, porta, login, senha;

	public LocalizarServicoIntegracao(TipoLocalizador tipoLocalizacao, String repositorio, String catalogo, String ip,
			String porta, String login, String senha) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
		this.repositorio = repositorio;
		this.catalogo = catalogo;
		this.ip = ip;
		this.porta = porta;
		this.login = login;
		this.senha = senha;

	}

	public LocalizarServicoIntegracao(TipoLocalizador tipoLocalizacao, String repositorio, String catalogo) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
		this.repositorio = repositorio;
		this.catalogo = catalogo;

	}

	public LocalizarServicoIntegracao(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoIntegracao() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public T getServico() {
		Properties prop = null;
		try {

			prop = criarPropriedades(ip, porta, login, senha);
			if (prop == null) {
				prop = criarPropriedadesDoAmbiente();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			prop = criarPropriedadesDefault();
		}

		try {
			Context context = new InitialContext(prop);
			T servico = (T) context.lookup(localizar());
			return servico;
		} catch (NamingException e) {
			e.printStackTrace();

			try {
				Context ctx = new InitialContext();
				T servico = (T) ctx.lookup(localizar());
				return servico;
			} catch (NamingException e1) {
				e1.printStackTrace();
			}

		}

		return null;
	}

	public String localizar() {

		String localizacao = super.localizar();
		if (localizacao != null) {
			localizacao = localizacao.replace("{repositorio}", this.repositorio);
			localizacao = localizacao.replace("{catalogo}", this.catalogo);
			return localizacao;
		}
		return "";
	}

}
