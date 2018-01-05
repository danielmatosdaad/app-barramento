package br.app.barramento.integracao.dto;

import java.util.Map;
import br.app.barramento.integracao.dto.DTO;

public class FiltroDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> campoValores;

	private TipoOperacaoDTO tipoOperacao;

	public FiltroDTO() {

	}

	public FiltroDTO(Map<String, String> campoValores, TipoOperacaoDTO tipoOperacao) {

		this.campoValores = campoValores;
		this.tipoOperacao = tipoOperacao;
	}

	public Map<String, String> getCampoValores() {
		return campoValores;
	}

	public TipoOperacaoDTO getTipoOperacao() {
		return tipoOperacao;
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

}
