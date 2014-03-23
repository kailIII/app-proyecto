package com.mycompany.proyecto.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 * 
 * @author rodrigo garcete
 * @since 21/03/2014
 *
 * @param <E> Entidad
 * @param <K> Codigo
 */
public abstract class BaseDao<E,K> implements Dao<E, K> {

	protected Class entityClass;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public BaseDao() {
		ParameterizedType genericSuperClass = (ParameterizedType)getClass().getGenericSuperclass();
		this.entityClass = (Class)genericSuperClass.getActualTypeArguments()[0];
	}
	
	public void save(E entity) {
		entityManager.merge(entity);
		entityManager.flush();
	}
	
	public void save(List<E> entities) {
		for (E entity : entities) {
			entityManager.merge(entity);
			entityManager.flush();
		}
	}
	
	public void remove(E entity) {
		entityManager.remove(entityManager.contains(entity) ? entity:entityManager.merge(entity));
	}
	
	public E findById(K id) {
		return (E)entityManager.find(entityClass, id);
	}
	
	public Class getEntityClass() {
		return entityClass;
	}
	
	public List<E> findAll() {
		Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
		return query.getResultList();
	}
}