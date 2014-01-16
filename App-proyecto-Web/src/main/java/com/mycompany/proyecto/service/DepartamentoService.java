package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Departamento;

/**
 * Contrato de Servicio para la entidad <code>Departamento</code>
 * @author rodrigo garcete
 * @since 21/11/2013
 */
public interface DepartamentoService {

	Departamento findById(Long codigo) throws DataAccessException;
	
	List<Departamento> findByName(String nombre) throws DataAccessException;
	
	List<Departamento> findByCombo() throws DataAccessException;

	List<Departamento> getAll() throws DataAccessException;
		
	void save(Departamento dep) throws DataAccessException;
		
	Boolean remove(Departamento dep) throws DataAccessException;
	
}