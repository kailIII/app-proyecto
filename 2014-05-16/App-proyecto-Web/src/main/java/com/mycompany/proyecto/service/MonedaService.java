package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Moneda;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface MonedaService {

	Moneda findById(Long codigo) throws DataAccessException;
	
	List<Moneda> findByName(String nombre) throws DataAccessException; 

	List<Moneda> getAll() throws DataAccessException;
		
	void save(Moneda moneda) throws DataAccessException;
		
	Boolean remove(Moneda moneda) throws DataAccessException;
	
}