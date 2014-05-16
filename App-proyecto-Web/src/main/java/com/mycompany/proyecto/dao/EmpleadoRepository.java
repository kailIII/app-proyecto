package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Empleado;

/**
 * Contrato de Persistencia para la entidad <code>Empleado</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface EmpleadoRepository extends Dao<Empleado, Serializable>{
	
	List<Empleado> findByName(String nombre) throws DataAccessException;
	
	List<Empleado> findByCombo() throws DataAccessException;
	
}