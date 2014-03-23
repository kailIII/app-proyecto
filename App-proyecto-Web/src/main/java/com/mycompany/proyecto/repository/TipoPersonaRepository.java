package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.TipoPersona;

/**
 * Contrato de Persistencia para la entidad <code>Tipo Persona</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface TipoPersonaRepository extends Dao<TipoPersona, Serializable>{
	
	List<TipoPersona> findByName(String nombre) throws DataAccessException; 
	
	List<TipoPersona> findByCombo() throws DataAccessException;
	
}