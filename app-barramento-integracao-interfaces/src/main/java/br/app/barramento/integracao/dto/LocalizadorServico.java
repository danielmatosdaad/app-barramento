package br.app.barramento.integracao.dto;

public interface LocalizadorServico<S> {

	public S getServico();

	public String localizar();
}
