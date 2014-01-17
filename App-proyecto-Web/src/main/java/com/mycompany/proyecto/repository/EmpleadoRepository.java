package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Empleado;

/**
 * Contrato de Persistencia para la entidad <code>Empleado</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface EmpleadoRepository {

	Empleado findById(Long codigo) throws DataAccessException;
	
	List<Empleado> findByName(String nombre) throws DataAccessException;
	
	List<Empleado> findByCombo() throws DataAccessException;

	List<Empleado> getAll() throws DataAccessException;
		
	void save(Empleado empleado) throws DataAccessException;
		
	Boolean remove(Empleado empleado) throws DataAccessException;
	
}