package br.app.barramento.integracao.dto;

import java.util.List;

public class EnvioDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Class<?> tipo;
	private DTO requisicao;
	private List<DTO> requisicoes;
	private int[] requisicoesNumericas;
	private String interfaces;
	private String delegate;
	private String reposta;
	private String envio;

	public EnvioDTO() {
	}

	public EnvioDTO(Object requisicao) {
		this.requisicao = (DTO) requisicao;
		this.envio = requisicao.getClass().getName();

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

	public Class<?> getTipo() {
		return tipo;
	}

	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public DTO getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(DTO requisicao) {
		this.requisicao = requisicao;
	}

	public String getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(String interfaces) {
		this.interfaces = interfaces;
	}

	public String getDelegate() {
		return delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}

	public String getReposta() {
		return reposta;
	}

	public void setReposta(String reposta) {
		this.reposta = reposta;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
	}

	public List<DTO> getRequisicoes() {
		return requisicoes;
	}

	public void setRequisicoes(List<DTO> requisicoes) {
		this.requisicoes = requisicoes;
	}

	public int[] getRequisicoesNumericas() {
		return requisicoesNumericas;
	}

	public void setRequisicoesNumericas(int[] requisicoesNumericas) {
		this.requisicoesNumericas = requisicoesNumericas;
	}

}
