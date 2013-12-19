package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Pago;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface PagoService {

	Pago findById(Long codigo) throws DataAccessException;
	
	List<Pago> findByName(String nombre) throws DataAccessException; 

	List<Pago> getAll() throws DataAccessException;
		
	void save(Pago pago) throws DataAccessException;
		
	Boolean remove(Pago pago) throws DataAccessException;
	
}