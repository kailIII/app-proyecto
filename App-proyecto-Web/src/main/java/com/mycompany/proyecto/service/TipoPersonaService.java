package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.TipoPersona;

/**
 * Contrato de Servicio para la entidad <code>TipoPersona</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface TipoPersonaService {

	TipoPersona findById(Long codigo) throws DataAccessException;
	
	List<TipoPersona> findByName(String nombre) throws DataAccessException; 
	
	List<TipoPersona> findByCombo() throws DataAccessException; 

	List<TipoPersona> getAll() throws DataAccessException;
		
	void save(TipoPersona tipoPerson) throws DataAccessException;
		
	Boolean remove(TipoPersona tipoPersona) throws DataAccessException;
	
}