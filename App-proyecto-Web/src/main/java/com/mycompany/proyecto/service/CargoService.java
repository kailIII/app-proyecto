package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Cargo;

/**
 * Contrato de Servicio para la entidad <code>Cargo</code>
 *   
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface CargoService {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	Cargo findById(Long codigo) throws DataAccessException;
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws DataAccessException
	 */
	List<Cargo> findByName(String nombre) throws DataAccessException;
	
	List<Cargo> findByCombo() throws DataAccessException;

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Cargo> getAll() throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param cargo
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(Cargo cargo) throws DataAccessException;
		
	/**
	 * 
	 * @param cargo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(Cargo cargo) throws DataAccessException;
	
}