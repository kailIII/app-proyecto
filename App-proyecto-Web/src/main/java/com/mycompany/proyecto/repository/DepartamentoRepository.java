package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Departamento;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface DepartamentoRepository {

	Departamento findById(Long codigo) throws DataAccessException;
	
	List<Departamento> findByName(String nombre) throws DataAccessException; 

	List<Departamento> getAll() throws DataAccessException;
		
	void save(Departamento dep) throws DataAccessException;
		
	Boolean remove(Departamento dep) throws DataAccessException;
	
}