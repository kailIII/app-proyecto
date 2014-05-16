package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.EstadoCivilRepository;
import com.mycompany.proyecto.model.EstadoCivil;
import com.mycompany.proyecto.service.EstadoCivilService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {
	
	private EstadoCivilRepository ecRepository;
	
	@Autowired
	public EstadoCivilServiceImpl(EstadoCivilRepository cr){
		this.ecRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public EstadoCivil findById(Long codigo) throws DataAccessException {
		return ecRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstadoCivil> findByName(String nombre) throws DataAccessException {
		return ecRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(EstadoCivil b) throws DataAccessException {
		ecRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstadoCivil> getAll() throws DataAccessException {
		return ecRepository.findAll();
	}

	@Override
	public Boolean remove(EstadoCivil c) throws DataAccessException {
		ecRepository.remove(c);
		return true;
	}

}