package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Cliente;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ClienteService {

	Cliente findById(Long codigo) throws DataAccessException;
	
	List<Cliente> findByName(String nombre) throws DataAccessException; 

	List<Cliente> getAll() throws DataAccessException;
		
	void save(Cliente cliente) throws DataAccessException;
		
	Boolean remove(Cliente cliente) throws DataAccessException;
	
}