package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Marca;
/**
 * Contrato de Persistencia para la entidad <code>Marca</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface MarcaRepository extends Dao<Marca, Serializable>{
	
	List<Marca> findByName(String nombre) throws DataAccessException;
	
	List<Marca> findByCombo() throws DataAccessException;
	
}