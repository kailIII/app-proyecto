package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Grupo;

/**
 * Contrato de Persistencia para la entidad <code>Grupo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo garcete
 * @since 21-11-2013
 */
public interface GrupoRepository extends Dao<Grupo, Serializable>{
	
	List<Grupo> findByName(String nombre) throws DataAccessException; 
	
	List<Grupo> findByCombo() throws DataAccessException; 
	
}