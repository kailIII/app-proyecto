package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Pago;

/**
 * Contrato de Persistencia para la entidad <code>Pago</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface PagoRepository extends Dao<Pago, Serializable>{
	
	List<Pago> findByName(String nombre) throws DataAccessException; 
	
}