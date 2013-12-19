package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Formula;

/**
 * Contrato de Persistencia para la entidad <code>Banco</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface FormulaService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Formula findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Formula> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Formula> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param banco
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Formula f) throws DataAccessException;
		
	/**
	 * 
	 * @param banco
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Formula f) throws DataAccessException;
	
}