package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Usuario;

/**
 * Contrato de Persistencia para la entidad <code>Usuario</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 * 
 * @author rodrigo garcete
 * Fecha Creacion:23/11/2013
 */
public interface UsuarioRepository extends Dao<Usuario, Serializable>{

	List<Usuario> findByName(String nombre) throws DataAccessException; 
	
}