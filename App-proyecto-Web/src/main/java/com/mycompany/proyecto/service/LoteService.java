package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Lote;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface LoteService {

	Lote findById(Long codigo) throws DataAccessException;
	
	List<Lote> findByName(String nombre) throws DataAccessException; 

	List<Lote> getAll() throws DataAccessException;
		
	void save(Lote ciudad) throws DataAccessException;
		
	Boolean remove(Lote ciudad) throws DataAccessException;
	
}