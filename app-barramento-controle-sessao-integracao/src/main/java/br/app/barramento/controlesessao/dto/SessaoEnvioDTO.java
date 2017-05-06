package br.app.barramento.controlesessao.dto;

import java.io.Serializable;
import java.util.Date;

public class SessaoEnvioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idetificadorAutenticacao;
	private String nomeIdentificadorAutenticacao;
	private String senha;
	private String ipporta;
	private String identificadorDispotivo;
	private String brownser;
	private Date datahora;
	private TipoSessao tipoSessao;

	public Long getIdetificadorAutenticacao() {
		return idetificadorAutenticacao;
	}

	public void setIdetificadorAutenticacao(Long idetificadorAutenticacao) {
		this.idetificadorAutenticacao = idetificadorAutenticacao;
	}

	public String getNomeIdentificadorAutenticacao() {
		return nomeIdentificadorAutenticacao;
	}

	public void setNomeIdentificadorAutenticacao(String nomeIdentificadorAutenticacao) {
		this.nomeIdentificadorAutenticacao = nomeIdentificadorAutenticacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIpporta() {
		return ipporta;
	}

	public void setIpporta(String ipporta) {
		this.ipporta = ipporta;
	}

	public String getIdentificadorDispotivo() {
		return identificadorDispotivo;
	}

	public void setIdentificadorDispotivo(String identificadorDispotivo) {
		this.identificadorDispotivo = identificadorDispotivo;
	}

	public String getBrownser() {
		return brownser;
	}

	public void setBrownser(String brownser) {
		this.brownser = brownser;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

	public TipoSessao getTipoSessao() {
		return tipoSessao;
	}

	public void setTipoSessao(TipoSessao tipoSessao) {
		this.tipoSessao = tipoSessao;
	}

}
