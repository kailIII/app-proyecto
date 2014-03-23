package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Concepto;

/**
 * Contrato de Persistencia para la entidad <code>Concepto</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ConceptoRepository extends Dao<Concepto, Serializable> {
	
	List<Concepto> findByName(String nombre) throws DataAccessException; 
	
}