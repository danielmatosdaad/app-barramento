package br.app.barramento.integracao.exception;

public class InfraEstruturaException extends TransacaoException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InfraEstruturaException() {
		// TODO Auto-generated constructor stub
	}

	public InfraEstruturaException(Exception e) {
		super(e);
	}

	public InfraEstruturaException(String descricao, Exception e) {
		super(descricao, e);
	}

	public InfraEstruturaException(int codioErro, String descricao) {
		super(codioErro, descricao);
	}

	public InfraEstruturaException(String descricao) {
		super(descricao);
	}
}
