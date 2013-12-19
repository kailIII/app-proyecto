package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Produccion;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ProduccionRepository {

	Produccion findById(Long codigo) throws DataAccessException;
	
	List<Produccion> findByName(String nombre) throws DataAccessException; 

	List<Produccion> getAll() throws DataAccessException;
		
	void save(Produccion produccion) throws DataAccessException;
		
	Boolean remove(Produccion produccion) throws DataAccessException;
	
}