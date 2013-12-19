package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Clasificacion;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ClasificacionRepository {

	Clasificacion findById(Long codigo) throws DataAccessException;
	
	List<Clasificacion> findByName(String nombre) throws DataAccessException; 

	List<Clasificacion> getAll() throws DataAccessException;
		
	void save(Clasificacion clasificacion) throws DataAccessException;
		
	Boolean remove(Clasificacion clasificacion) throws DataAccessException;
	
}