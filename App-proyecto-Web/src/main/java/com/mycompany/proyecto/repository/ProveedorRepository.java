package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Proveedor;

/**
 * Contrato de Persistencia para la entidad <code>Proveedor</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 * @author Rodrigo Garcete
 * @since 23/11/2013
 */
public interface ProveedorRepository extends Dao<Proveedor, Serializable>{

	List<Proveedor> findByName(String nombre) throws DataAccessException; 
	
	List<Proveedor> findByCombo() throws DataAccessException; 
	
}
