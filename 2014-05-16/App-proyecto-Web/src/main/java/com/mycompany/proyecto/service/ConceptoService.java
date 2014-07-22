package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Concepto;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ConceptoService {

	Concepto findById(Long codigo) throws DataAccessException;
	
	List<Concepto> findByName(String nombre) throws DataAccessException; 

	List<Concepto> getAll() throws DataAccessException;
		
	void save(Concepto concepto) throws DataAccessException;
		
	Boolean remove(Concepto concepto) throws DataAccessException;
	
}