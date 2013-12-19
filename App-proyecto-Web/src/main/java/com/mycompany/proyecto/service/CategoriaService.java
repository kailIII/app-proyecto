package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Categoria;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface CategoriaService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Categoria findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Categoria> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Categoria> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param categoria
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Categoria categoria) throws DataAccessException;
		
	/**
	 * 
	 * @param categoria
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Categoria categoria) throws DataAccessException;
	
}