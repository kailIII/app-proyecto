package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Egreso;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface EgresoService {

	Egreso findById(Long codigo) throws DataAccessException;
	
	List<Egreso> findByName(String nombre) throws DataAccessException; 

	List<Egreso> getAll() throws DataAccessException;
		
	void save(Egreso egreso) throws DataAccessException;
		
	Boolean remove(Egreso egreso) throws DataAccessException;
	
}