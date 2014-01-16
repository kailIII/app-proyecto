package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Producto;

/**
 * Interfaz de Servicio, que provee los metodos necesarios
 * para el proceso de negocio
 *
 * @author Rodrigo Garcete
 * @since 25/11/2013
 */
public interface ProductoService {
	
	Producto findById(Long codigo) throws DataAccessException;
	
	List<Producto> findByName(String nombre) throws DataAccessException;
	
	void save(Producto p) throws DataAccessException;
	
	List<Producto> getAll() throws DataAccessException;
	
	Boolean remove(Producto p) throws DataAccessException;

}