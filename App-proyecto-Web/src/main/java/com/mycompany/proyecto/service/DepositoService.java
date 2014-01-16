package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Deposito;

/**
 * Contrato de Servicio para la entidad <code>Deposito</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface DepositoService {

	Deposito findById(Long codigo) throws DataAccessException;
	
	List<Deposito> findByName(String nombre) throws DataAccessException; 
	
	List<Deposito> findByCombo() throws DataAccessException; 

	List<Deposito> getAll() throws DataAccessException;
		
	void save(Deposito deposito) throws DataAccessException;
		
	Boolean remove(Deposito deposito) throws DataAccessException;
	
}