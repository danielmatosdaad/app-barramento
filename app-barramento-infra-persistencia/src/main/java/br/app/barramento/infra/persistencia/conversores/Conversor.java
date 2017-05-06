package br.app.barramento.infra.persistencia.conversores;

import org.modelmapper.ModelMapper;

import br.app.barramento.integracao.exception.InfraEstruturaException;

public class Conversor {

	public static <T> T converter(Object objeto, Class<T> destino) throws InfraEstruturaException {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(objeto, destino);

	}
}
