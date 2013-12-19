package com.mycompany.proyecto.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Marca;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface MarcaRepository {

	Marca findById(Long codigo) throws DataAccessException;
	
	List<Marca> findByName(String nombre) throws DataAccessException; 

	List<Marca> getAll() throws DataAccessException;
		
	void save(Marca marca) throws DataAccessException;
		
	Boolean remove(Marca marca) throws DataAccessException;
	
}