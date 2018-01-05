package br.app.barramento.integracao.dto;

import java.util.List;

public class EnvioDTO implements DTO {

	/**
	 * 
	 */

	private String tokenAutenticacao;
	private String tokenAutorizacao;
	private String nomeIdentificadorAutenticacao;
	private String ip;
	private String porta;
	private String identificadorDispotivo;
	private String nomeRepositorio;
	private String nomeCatalogo;
	private String acao;
	private DTO requisicao;
	private List<DTO> requisicoes;
	private String interfaces;
	private String envio;
	private String reposta;
	private String delegate;

	public EnvioDTO(final String tokenAutenticacao, final String tokenAutorizacao,
			final String nomeIdentificadorAutenticacao, final String ip, final String porta,
			final String identificadorDispotivo, final String nomeRepositorio, final String nomeCatalogo,
			final String acao, final DTO requisicao, final List<DTO> requisicoes) {

		this.tokenAutenticacao = tokenAutenticacao;
		this.tokenAutorizacao = tokenAutorizacao;
		this.nomeIdentificadorAutenticacao = nomeIdentificadorAutenticacao;
		this.ip = ip;
		this.porta = porta;
		this.identificadorDispotivo = identificadorDispotivo;
		this.nomeRepositorio = nomeRepositorio;
		this.nomeCatalogo = nomeCatalogo;
		this.acao = acao;
		this.requisicao = requisicao;
		this.requisicoes = requisicoes;
		this.envio = requisicao.getClass().getName();

	}

	public EnvioDTO() {
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public DTO getRequisicao() {
		return requisicao;
	}

	public List<DTO> getRequisicoes() {
		return requisicoes;
	}

	public String getTokenAutenticacao() {
		return tokenAutenticacao;
	}

	public String getTokenAutorizacao() {
		return tokenAutorizacao;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
	}

	public String getReposta() {
		return reposta;
	}

	public void setReposta(String reposta) {
		this.reposta = reposta;
	}

	public String getDelegate() {
		return delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}

	public String getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(String interfaces) {
		this.interfaces = interfaces;
	}

	public String getNomeRepositorio() {
		return nomeRepositorio;
	}

	public String getNomeCatalogo() {
		return nomeCatalogo;
	}

	public String getAcao() {
		return acao;
	}

	public String getIp() {
		return ip;
	}

	public String getPorta() {
		return porta;
	}

	public String getIdentificadorDispotivo() {
		return identificadorDispotivo;
	}

	public String getNomeIdentificadorAutenticacao() {
		return nomeIdentificadorAutenticacao;
	}

}
