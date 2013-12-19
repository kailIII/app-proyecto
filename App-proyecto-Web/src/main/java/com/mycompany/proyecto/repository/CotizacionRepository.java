package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Cotizacion;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface CotizacionRepository {

	Cotizacion findById(Long codigo) throws DataAccessException;
	
	List<Cotizacion> findByName(String nombre) throws DataAccessException; 

	List<Cotizacion> getAll() throws DataAccessException;
		
	void save(Cotizacion cotizacion) throws DataAccessException;
		
	Boolean remove(Cotizacion cotizacion) throws DataAccessException;
	
}