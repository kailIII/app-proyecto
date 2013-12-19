package com.mycompany.proyecto.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Insumo;

/**
 * Mostly used as a facade for all Petclinic controllers
 *
 * @author Michael Isvy
 */
public interface InsumoService {
	
	Insumo findById(Long codigo) throws DataAccessException;
	
	Collection<Insumo> findByName(String nombre) throws DataAccessException;
	
	void save(Insumo insumo) throws DataAccessException;
	
	List<Insumo> getAll() throws DataAccessException;
	
	Boolean remove(Insumo insumo) throws DataAccessException;

}