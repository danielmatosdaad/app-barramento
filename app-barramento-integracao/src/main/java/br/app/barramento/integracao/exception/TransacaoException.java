package br.app.barramento.integracao.exception;

import br.app.barramento.integracao.interfaces.IException;

public class TransacaoException extends Exception implements IException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigoErro = -1;
	private String descricao = "";

	public TransacaoException() {
		// TODO Auto-generated constructor stub
	}

	public TransacaoException(Exception e) {
		super(e);
	}

	public TransacaoException(String descricao, Exception e) {
		super(descricao, e);
	}

	public TransacaoException(String descricao) {
		super(descricao);
	}

	public TransacaoException(int codioErro, String descricao) {
		super(descricao);
		this.codigoErro = codioErro;
		this.descricao = descricao;
	}

	public int codigoErro() {
		// TODO Auto-generated method stub
		return this.codigoErro;
	}

	public String descricaoErro() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

	public StackTraceElement[] getPilhaErro() {
		// TODO Auto-generated method stub
		return null;
	}

}
