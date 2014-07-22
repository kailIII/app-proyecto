package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Proveedor;

/**
 * 
 * @author Rodrigo Garcete
 * @since 23/11/2013
 */
public interface ProveedorService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Proveedor findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Proveedor> findByName(String nombre) throws DataAccessException; 
	
	List<Proveedor> findByCombo() throws DataAccessException;

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Proveedor> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de usuario en la base de datos
	 * @param usuario
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Proveedor usuario) throws DataAccessException;
		
	/**
	 * 
	 * @param insumo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Proveedor usuario) throws DataAccessException;
}
