package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.RecepcionInsumo;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface RecepcionInsumoRepository {

	RecepcionInsumo findById(Long codigo) throws DataAccessException;
	
	List<RecepcionInsumo> findByName(String nombre) throws DataAccessException; 

	List<RecepcionInsumo> getAll() throws DataAccessException;
		
	void save(RecepcionInsumo recepcionInsumo) throws DataAccessException;
		
	Boolean remove(RecepcionInsumo recepcionInsumo) throws DataAccessException;
	
}