package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Producto;

/**
 * Contrato de Persistencia para la entidad <code>Producto</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface ProductoRepository extends Dao<Producto, Serializable>{

	List<Producto> findByName(String nombre, int pag) throws DataAccessException; 
	
	List<Producto> findByCombo() throws DataAccessException; 
	
	List<Producto> findByInsumo() throws DataAccessException; 

}