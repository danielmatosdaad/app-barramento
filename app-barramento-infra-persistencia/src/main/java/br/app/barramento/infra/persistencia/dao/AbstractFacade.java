package br.app.barramento.infra.persistencia.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.app.barramento.infra.persistencia.util.ConsultaCriteriaBuilder;
import br.app.barramento.integracao.dao.interfaces.Entidade;
import br.app.barramento.integracao.dto.TipoOperacaoDTO;

public abstract class AbstractFacade<T extends Entidade> implements IFacedeDAO<T> {

	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	@Override
	public T registrar(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public void registrarLista(List<T> list) {

		for (T t : list) {
			registrar(t);
		}
	}

	@Override
	public T editar(T entity) {
		getEntityManager().merge(entity);

		return entity;
	}

	@Override
	public void removerLista(List<T> list) {

		for (T t : list) {
			remover(t);
		}
	}

	@Override
	public void remover(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	@Override
	public T buscar(Object id) {
		T resultado = getEntityManager().find(entityClass, id);
		return resultado;

	}
	
	@Override
	public List<T> buscarTodos() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));

		List<T> resultado = getEntityManager().createQuery(cq).getResultList();

		return resultado;
	}
	
	@Override
	public long count() {

		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		long resultado = ((Long) q.getSingleResult()).longValue();
		return resultado;
	}

	@Override
	public List<T> queryList(String queryText, Object[] parameters) {
		return query(queryText, parameters).getResultList();
	}

	@Override
	public void executeUpdate(String sqlCommand, Object[] parameters) {
		Query query = query(sqlCommand, parameters);
		query.executeUpdate();
	}
	
	@Override
	public Query query(String queryText, Object[] parameters) {
		Query query = getEntityManager().createQuery(queryText);
		if (parameters != null) {
			int i = 1;
			for (Object parameter : parameters) {
				if (parameter == null)
					throw new IllegalArgumentException(
							"Binding parameter at position " + i + " can not be null: " + queryText);
				query.setParameter(i, parameter);
				i++;
			}
		}
		return query;
	}

	@Override
	public void removerComCriteria(CriteriaDelete<T> criteria) {
		getEntityManager().createQuery(criteria).executeUpdate();
	}
	
	@Override
	public void removerPorId(long id) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaDelete<T> delete = cb.createCriteriaDelete(this.entityClass);
		CriteriaQuery<T> criteria = cb.createQuery(this.entityClass);
		Root<T> root = criteria.from(this.entityClass);
		delete.where(root.get("id").in(id));
		removerComCriteria(delete);
	}

	@Override
	public T buscarPorId(long id) {

		return getEntityManager().find(this.entityClass, id);
	}

	@Override
	public List<T> buscarPorIntervalo(int[] range) {

		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);

		List<T> resultado = q.getResultList();
		return resultado;
	}

	@Override
	public List<T> listaComCriteria(CriteriaQuery<T> criteria) {
		return getEntityManager().createQuery(criteria).getResultList();
	}

	@Override
	public List<T> listaPaginadaComCriteria(CriteriaQuery<T> criteria, int pagina, int resultados) {
		TypedQuery<T> query = getEntityManager().createQuery(criteria);
		query.setFirstResult((pagina - 1) * resultados);
		query.setMaxResults(resultados);
		return query.getResultList();
	}

	@Override
	public T consultaComCriteria(CriteriaQuery<T> criteria) {
		return getEntityManager().createQuery(criteria).getSingleResult();
	}

	@Override
	public List<T> listaPaginadaComFiltro(Map<String, String> campoValores, TipoOperacaoDTO tipoOperacao, int pagina,
			int resultados) {
		if (campoValores == null || campoValores.isEmpty() || tipoOperacao == null) {

			return null;
		}
		CriteriaQuery<T> criteria = ConsultaCriteriaBuilder.criarConsulta(getEntityManager(), entityClass, campoValores,
				tipoOperacao);
		TypedQuery<T> query = getEntityManager().createQuery(criteria);
		query.setFirstResult((pagina - 1) * resultados);
		query.setMaxResults(resultados);
		return query.getResultList();
	}

	@Override
	public List<T> filtrar(Map<String, String> campoValores, TipoOperacaoDTO tipoOperacao) {

		if (campoValores == null || campoValores.isEmpty() || tipoOperacao == null) {

			return null;
		}
		CriteriaQuery<T> criteria = ConsultaCriteriaBuilder.criarConsulta(getEntityManager(), entityClass, campoValores,
				tipoOperacao);

		return listaComCriteria(criteria);
	}

}
