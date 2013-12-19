package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Ciudad;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface CiudadService {

	Ciudad findById(Long codigo) throws DataAccessException;
	
	List<Ciudad> findByName(String nombre) throws DataAccessException; 

	List<Ciudad> getAll() throws DataAccessException;
		
	void save(Ciudad ciudad) throws DataAccessException;
		
	Boolean remove(Ciudad ciudad) throws DataAccessException;
	
}