package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Produccion;

/**
 * Contrato de Persistencia para la entidad <code>Produccion</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ProduccionRepository extends Dao<Produccion, Serializable>{
	
	List<Produccion> findByName(String nombre) throws DataAccessException; 
	
}