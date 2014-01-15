package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.TipoPersona;
import com.mycompany.proyecto.repository.TipoPersonaRepository;
import com.mycompany.proyecto.service.TipoPersonaService;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {
	
	private TipoPersonaRepository tipoPersonaRepository;
	
	@Autowired
	public TipoPersonaServiceImpl(TipoPersonaRepository cr){
		this.tipoPersonaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public TipoPersona findById(Long codigo) throws DataAccessException {
		return tipoPersonaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoPersona> findByName(String nombre) throws DataAccessException {
		return tipoPersonaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(TipoPersona b) throws DataAccessException {
		tipoPersonaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoPersona> getAll() throws DataAccessException {
		return tipoPersonaRepository.getAll();
	}

	@Override
	public Boolean remove(TipoPersona c) throws DataAccessException {
		tipoPersonaRepository.remove(c);
		return true;
	}

}
