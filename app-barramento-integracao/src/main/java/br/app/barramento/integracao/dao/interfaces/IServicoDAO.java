package br.app.barramento.integracao.dao.interfaces;

import java.util.List;

import br.app.barramento.integracao.dto.DTO;
import br.app.barramento.integracao.dto.FiltroDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IServicoDAO<T extends DTO> extends IService {

	public T adiconar(T dto) throws InfraEstruturaException, NegocioException;

	public List<T> adiconar(List<T> listaDto) throws InfraEstruturaException, NegocioException;

	public T alterar(T dto) throws InfraEstruturaException, NegocioException;

	public void remover(T dto) throws InfraEstruturaException, NegocioException;

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException;

	public List<T> bustarTodos() throws InfraEstruturaException, NegocioException;

	public T bustarPorID(Long id) throws InfraEstruturaException, NegocioException;

	public List<T> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException;

	List<T> listaComFiltro(FiltroDTO filtroDTO, int results, int page) throws InfraEstruturaException, NegocioException;
}
