package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Ingreso;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface IngresoRepository {

	Ingreso findById(Long codigo) throws DataAccessException;
	
	List<Ingreso> findByName(String nombre) throws DataAccessException; 

	List<Ingreso> getAll() throws DataAccessException;
		
	void save(Ingreso ingreso) throws DataAccessException;
		
	Boolean remove(Ingreso ingreso) throws DataAccessException;
	
}