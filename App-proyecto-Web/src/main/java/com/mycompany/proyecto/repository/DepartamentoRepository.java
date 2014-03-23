package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Departamento;

/**
 * Contrato de Persistencia para la entidad <code>Departamento</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface DepartamentoRepository extends Dao<Departamento, Serializable>{
	
	List<Departamento> findByName(String nombre) throws DataAccessException; 
	
	List<Departamento> findByCombo() throws DataAccessException; 
	
}