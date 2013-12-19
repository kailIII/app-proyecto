package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.EstadoCivil;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface EstadoCivilRepository {

	EstadoCivil findById(Long codigo) throws DataAccessException;
	
	List<EstadoCivil> findByName(String nombre) throws DataAccessException; 

	List<EstadoCivil> getAll() throws DataAccessException;
		
	void save(EstadoCivil estadoCivil) throws DataAccessException;
		
	Boolean remove(EstadoCivil estadoCivil) throws DataAccessException;
	
}