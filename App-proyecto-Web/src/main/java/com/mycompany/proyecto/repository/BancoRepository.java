package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Banco;

/**
 * Contrato de Persistencia para la entidad <code>Banco</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface BancoRepository {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Banco findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Banco> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Banco> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param banco
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Banco banco) throws DataAccessException;
		
	/**
	 * 
	 * @param banco
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Banco banco) throws DataAccessException;
	
}