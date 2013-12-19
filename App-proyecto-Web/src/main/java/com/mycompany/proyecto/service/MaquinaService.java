package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Maquina;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface MaquinaService {

	Maquina findById(Long codigo) throws DataAccessException;
	
	List<Maquina> findByName(String nombre) throws DataAccessException; 

	List<Maquina> getAll() throws DataAccessException;
		
	void save(Maquina maquina) throws DataAccessException;
		
	Boolean remove(Maquina maquina) throws DataAccessException;
	
}