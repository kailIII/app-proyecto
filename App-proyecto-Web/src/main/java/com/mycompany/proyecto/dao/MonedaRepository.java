package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Moneda;

/**
 * Contrato de Persistencia para la entidad <code>Moneda</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface MonedaRepository extends Dao<Moneda, Serializable>{
	
	List<Moneda> findByName(String nombre) throws DataAccessException; 
	
}