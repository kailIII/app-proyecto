package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Impuesto;

/**
 * Contrato de Persistencia para la entidad <code>Impuesto</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface ImpuestoRepository extends Dao<Impuesto, Serializable>{
	
	List<Impuesto> findByName(String nombre) throws DataAccessException;
	
	List<Impuesto> findByCombo() throws DataAccessException; 
	
}