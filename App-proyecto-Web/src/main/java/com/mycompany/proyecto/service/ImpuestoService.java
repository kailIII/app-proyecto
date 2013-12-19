package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Impuesto;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ImpuestoService {

	Impuesto findById(Long codigo) throws DataAccessException;
	
	List<Impuesto> findByName(String nombre) throws DataAccessException; 

	List<Impuesto> getAll() throws DataAccessException;
		
	void save(Impuesto impuesto) throws DataAccessException;
		
	Boolean remove(Impuesto impuesto) throws DataAccessException;
	
}