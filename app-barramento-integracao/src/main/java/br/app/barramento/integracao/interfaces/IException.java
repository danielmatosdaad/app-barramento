package br.app.barramento.integracao.interfaces;

public interface IException {

	public int codigoErro();
	public String descricaoErro();
	public StackTraceElement[] getPilhaErro();
	
}
