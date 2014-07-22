package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Cuenta;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface CuentaService {

	Cuenta findById(Long codigo) throws DataAccessException;
	
	List<Cuenta> findByName(String nombre) throws DataAccessException; 

	List<Cuenta> getAll() throws DataAccessException;
		
	void save(Cuenta cuenta) throws DataAccessException;
		
	Boolean remove(Cuenta cuenta) throws DataAccessException;
	
}