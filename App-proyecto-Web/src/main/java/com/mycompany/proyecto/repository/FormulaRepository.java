package com.mycompany.proyecto.repository;

import java.io.Serializable;
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
public interface FormulaRepository extends Dao<Formula, Serializable> {

	List<Formula> findByName(String nombre) throws DataAccessException; 

	void save(Formula f, List<FormulaDetalle> fDetalles) throws DataAccessException;
	
}