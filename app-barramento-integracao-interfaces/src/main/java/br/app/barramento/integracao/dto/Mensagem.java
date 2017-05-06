package br.app.barramento.integracao.dto;

import java.io.Serializable;

public enum Mensagem implements Serializable {

	SUCESSO(1, "Sucesso"), ERRO(2, "Erro ao executar transacao"),SEM_RESPOSTA(3,"Nao houve resposta");

	private Mensagem(Integer codigo, String erro) {
		this.codigo = codigo;
		this.erro = erro;
	}

	private Integer codigo;
	private String erro;
	private Exception excecao;
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public Exception getExcecao() {
		return excecao;
	}

	public void setExcecao(Exception excecao) {
		this.excecao = excecao;
	}

}
