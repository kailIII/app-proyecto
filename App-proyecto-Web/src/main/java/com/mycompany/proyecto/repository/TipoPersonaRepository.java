package com.mycompany.proyecto.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.TipoPersona;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface TipoPersonaRepository {

	TipoPersona findById(Long codigo) throws DataAccessException;
	
	List<TipoPersona> findByName(String nombre) throws DataAccessException; 

	List<TipoPersona> getAll() throws DataAccessException;
		
	void save(TipoPersona tipoPerson) throws DataAccessException;
		
	Boolean remove(TipoPersona tipoPersona) throws DataAccessException;
	
}