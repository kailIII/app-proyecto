package com.mycompany.proyecto.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Venta;
import com.mycompany.proyecto.model.VentaDetalle;

/**
 * Contrato de Persistencia para la entidad <code>Venta</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:22-01-2014
 */
public interface VentaRepository {

	Venta findById(Long codigo) throws DataAccessException;
	
	List<Venta> findByName(String nombre) throws DataAccessException; 

	List<Venta> getAll() throws DataAccessException;
		
	void save(Venta v) throws DataAccessException;
	
	void save(Venta v, ArrayList<VentaDetalle> items) throws DataAccessException;
		
	Boolean remove(Venta v) throws DataAccessException;
	
}
