package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.FormaPago;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface FormaPagoRepository {

	FormaPago findById(Long codigo) throws DataAccessException;
	
	List<FormaPago> findByName(String nombre) throws DataAccessException; 

	List<FormaPago> getAll() throws DataAccessException;
		
	void save(FormaPago formaPago) throws DataAccessException;
		
	Boolean remove(FormaPago formaPago) throws DataAccessException;
	
}