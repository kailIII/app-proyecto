package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Producto;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface ProductoRepository {

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
	List<Producto> findByName(String nombre, int pag) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Producto> getAll(int pag) throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param insumo
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Producto p) throws DataAccessException;
		
	/**
	 * 
	 * @param insumo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Producto p) throws DataAccessException;
	
}