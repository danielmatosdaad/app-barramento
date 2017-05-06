package br.app.barramento.erro.interfaces;

public interface IAnaliseErro {

	public int getCodigo();

	public void setCodigo(int codigo);

	public String getMensagem();

	public void setMensagem(String mensagem);

	public int getTipo();

	public void setTipo(int tipo);

}
