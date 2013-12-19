package com.mycompany.proyecto.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Usuario;

/**
 * 
 * @author rodrigo garcete
 * Fecha Creacion:23/11/2013
 */
public interface UsuarioRepository {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Usuario findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Usuario> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Usuario> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de usuario en la base de datos
	 * @param usuario
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Usuario usuario) throws DataAccessException;
		
	/**
	 * 
	 * @param insumo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Usuario usuario) throws DataAccessException;
	
}