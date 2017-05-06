package br.app.barramento.integracao.dto;

import java.util.List;

public class RespostaDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Class<?> tipo;

	private DTO resultado;
	private List<? extends DTO> listaResultado;

	private Mensagem mensagem;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public DTO getResultado() {
		return resultado;
	}

	public void setResultado(DTO resultado) {
		this.resultado = resultado;
	}

	public Class<?> getTipo() {
		return tipo;
	}

	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<? extends DTO> getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List<? extends DTO> listaResultado) {
		this.listaResultado = listaResultado;
	}

}
