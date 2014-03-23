package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Cliente;

/**
 * Contrato de Persistencia para la entidad <code>Cliente</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since :21/11/2013
 */
public interface ClienteRepository extends Dao<Cliente, Serializable> {
	
	List<Cliente> findByName(String nombre) throws DataAccessException;
	
	List<Cliente> findByCombo() throws DataAccessException;
	
}