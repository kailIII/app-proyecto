package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Operacion;
import com.mycompany.proyecto.repository.OperacionRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class OperacionServiceImpl implements OperacionService {
	
	private OperacionRepository operacionRepository;
	
	@Autowired
	public OperacionServiceImpl(OperacionRepository cr){
		this.operacionRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Operacion findById(Long codigo) throws DataAccessException {
		return operacionRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Operacion> findByName(String nombre) throws DataAccessException {
		return operacionRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Operacion b) throws DataAccessException {
		operacionRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Operacion> getAll() throws DataAccessException {
		return operacionRepository.getAll();
	}

	@Override
	public Boolean remove(Operacion c) throws DataAccessException {
		operacionRepository.remove(c);
		return true;
	}

}
