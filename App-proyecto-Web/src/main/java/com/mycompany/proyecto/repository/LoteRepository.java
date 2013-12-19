package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Lote;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface LoteRepository {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Lote findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Lote> findByName(String nombre) throws DataAccessException; 

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Lote> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param cargo
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Lote lote) throws DataAccessException;
		
	/**
	 * 
	 * @param cargo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Lote lote) throws DataAccessException;
	
}