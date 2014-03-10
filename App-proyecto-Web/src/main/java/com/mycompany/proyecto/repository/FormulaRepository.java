package com.mycompany.proyecto.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Formula;
import com.mycompany.proyecto.model.FormulaDetalle;

/**
 * Contrato de Persistencia para la entidad <code>Formula</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface FormulaRepository {

	/**
	 * 
	 * @param codigo de formula
	 * @return el objeto Formula
	 * @throws DataAccessException
	 */
	Formula findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre de la formula
	 * @return Lista de Objetos de tipo Formula
	 * @throws DataAccessException
	 */
	List<Formula> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return Lista de objetos de tipo Formula
	 * @throws DataAccessException
	 */
	List<Formula> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion del registro formula en la base de datos
	 * @param formula, objeto
	 * @throws DataAccessException
	 */
	void save(Formula formula) throws DataAccessException;
	
	void save(Formula f, List<FormulaDetalle> fDetalles) throws DataAccessException;
		
	/**
	 * 
	 * @param formula
	 * @return valor booleano si se ha removido correctamente
	 * @throws DataAccessException
	 */
	Boolean remove(Formula formula) throws DataAccessException;
	
}