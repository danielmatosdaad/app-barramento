package br.app.barramento.integracao.dto;

import java.util.Map;

public interface FiltroQuery<T extends DTO> {

	public Map<String, String> getFiltro();

}
