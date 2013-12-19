package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.UnidadMedida;

/**
 * 
 * @author rodrigo garcete
 * Fecha Creacion:23/11/2013
 */
public interface UnidadMedidaService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	UnidadMedida findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<UnidadMedida> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<UnidadMedida> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de usuario en la base de datos
	 * @param usuario
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(UnidadMedida umedida) throws DataAccessException;
		
	/**
	 * 
	 * @param insumo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(UnidadMedida umedida) throws DataAccessException;
	
}
