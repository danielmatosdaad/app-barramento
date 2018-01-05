package br.app.barramento.integracao.dao.interfaces;

import java.util.List;
import java.util.Map;

import br.app.barramento.integracao.dto.DTO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IServicoConsultaDAO<T extends DTO> {

	public List<T> executarQueryFiltro(Map<String, String> parametros) throws InfraEstruturaException, NegocioException;

	public List<T> bustarTodos() throws InfraEstruturaException, NegocioException;

	public T bustarPorID(Long id) throws InfraEstruturaException, NegocioException;

	public List<T> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException;

}
