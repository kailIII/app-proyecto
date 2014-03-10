package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Formula;
import com.mycompany.proyecto.model.FormulaDetalle;

/**
 * Contrato de Servicio para la entidad <code>Formula</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface FormulaService {

	/**
	 * 
	 * @param codigo
	 * @return Un objeto formula
	 * @throws DataAccessException
	 */
	Formula findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return Lista de objetos de tipo Formula
	 * @throws DataAccessException
	 */
	List<Formula> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return Lista deO Objetos de tipo Formula
	 * @throws DataAccessException
	 */
	List<Formula> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion del objeto Formula en la base de datos
	 * @param f objeto
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Formula f) throws DataAccessException;
	
	void save(Formula f, List<FormulaDetalle> fDetalles) throws DataAccessException;
		
	/**
	 * 
	 * @param f El Objeto a ser eliminado
	 * @return true/false
	 * @throws DataAccessException
	 */
	Boolean remove(Formula f) throws DataAccessException;
	
}