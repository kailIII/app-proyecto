package com.mycompany.proyecto.repository;

import java.util.List;
/**
 * 
 * @author rodrigo garcete
 * @since 21/03/2014
 *
 * @param <E> Entidad
 * @param <K> Codigo
 * 
 * Interfaz Generica
 */
public interface Dao <E, K> {

	void save(E entity);
	
	void save(List<E> entity);
	
	void remove(E entity);
	
	E findById(K id);
	
	List<E> findAll();
	
	Class getEntityClass();
	
}