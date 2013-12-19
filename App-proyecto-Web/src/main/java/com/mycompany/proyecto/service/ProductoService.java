package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Producto;

/**
 * 
 * @author rodrigo garcete
 * Fecha Creacion:23/11/2013
 */
public interface ProductoService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Producto findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Producto> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Producto> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de usuario en la base de datos
	 * @param usuario
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Producto usuario) throws DataAccessException;
		
	/**
	 * 
	 * @param insumo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Producto usuario) throws DataAccessException;
	
}
