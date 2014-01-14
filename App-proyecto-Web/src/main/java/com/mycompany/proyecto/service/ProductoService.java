package com.mycompany.proyecto.service;

import java.util.Collection;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Producto;

/**
 * Mostly used as a facade for all Petclinic controllers
 *
 * @author Michael Isvy
 */
public interface ProductoService {
	
	Producto findById(Long codigo) throws DataAccessException;
	
	Collection<Producto> findByName(String nombre) throws DataAccessException;
	
	void save(Producto insumo) throws DataAccessException;
	
	List<Producto> getAll() throws DataAccessException;
	
	Boolean remove(Producto insumo) throws DataAccessException;

}