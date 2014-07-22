package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Compra;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface CompraService {

	Compra findById(Long codigo) throws DataAccessException;
	
	List<Compra> findByName(String nombre) throws DataAccessException; 

	List<Compra> getAll() throws DataAccessException;
		
	void save(Compra compra) throws DataAccessException;
		
	Boolean remove(Compra compra) throws DataAccessException;
	
}