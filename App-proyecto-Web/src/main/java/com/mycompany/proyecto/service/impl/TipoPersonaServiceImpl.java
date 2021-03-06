package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.TipoPersonaRepository;
import com.mycompany.proyecto.model.TipoPersona;
import com.mycompany.proyecto.service.TipoPersonaService;

/**
 * Implementacion de la Capa de Servicio para 
 * la entidad TipoPersona
 *
 * @author Rodrigo Garcete
 * @since 21/11/2012
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
		return tipoPersonaRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(TipoPersona c) throws DataAccessException {
		tipoPersonaRepository.remove(c);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoPersona> findByCombo() throws DataAccessException {
		return tipoPersonaRepository.findByCombo();
	}

}