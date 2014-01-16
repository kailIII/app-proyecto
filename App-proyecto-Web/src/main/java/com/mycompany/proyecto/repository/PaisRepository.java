package com.mycompany.proyecto.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.config.SearchCriteria;
import com.mycompany.proyecto.model.Pais;

/**
 * Contrato de Persistencia para la entidad <code>Pais</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface PaisRepository {

	Pais findById(Long codigo) throws DataAccessException;
	
	List<Pais> findByName(String nombre) throws DataAccessException;
	
	List<Pais> findByCombo() throws DataAccessException;
	
	List<Pais> findPais(SearchCriteria palabra) throws DataAccessException;

	List<Pais> getAll() throws DataAccessException;
		
	void save(Pais pais) throws DataAccessException;
		
	Boolean remove(Pais pais) throws DataAccessException;
	
}