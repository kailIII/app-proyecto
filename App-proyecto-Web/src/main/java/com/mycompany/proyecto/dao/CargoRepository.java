package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import com.mycompany.proyecto.model.Cargo;

/**
 * Contrato de Persistencia para la entidad <code>Cargo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface CargoRepository extends Dao<Cargo, Serializable> {

	List<Cargo> findByName(String nombre); 
	
	List<Cargo> findByCombo(); 
	
}