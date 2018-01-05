package br.app.barramento.infra.persistencia.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

import br.app.barramento.integracao.dao.interfaces.Entidade;
import br.app.barramento.integracao.dto.TipoOperacaoDTO;

public interface IFacedeDAO<E extends Entidade> {

	public E registrar(E enEidade);

	public void registrarLista(List<E> list);

	public E editar(E enEidade);

	public void remover(E enEidade);

	public E buscar(Object id);

	public List<E> buscarTodos();

	public List<E> buscarPorIntervalo(int[] range);

	public long count();

	void removerComCriteria(CriteriaDelete<E> criteria);

	List<E> listaComCriteria(CriteriaQuery<E> criteria);

	List<E> listaPaginadaComCriteria(CriteriaQuery<E> criteria, int pagina, int resultados);

	E consultaComCriteria(CriteriaQuery<E> criteria);

	List<E> listaPaginadaComFiltro(Map<String, String> campoValores, TipoOperacaoDTO tipoOperacao, int pagina,
			int resultados);

	List<E> filtrar(Map<String, String> campoValores, TipoOperacaoDTO tipoOperacao);

	E buscarPorId(long id);

	void removerPorId(long id);

	void removerLista(List<E> list);

	List<E> queryList(String queryText, Object[] parameters);

	void executeUpdate(String sqlCommand, Object[] parameters);

	Query query(String queryText, Object[] parameters);

}
