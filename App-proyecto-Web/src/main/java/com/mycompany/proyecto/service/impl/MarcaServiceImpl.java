package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.MarcaRepository;
import com.mycompany.proyecto.model.Marca;
import com.mycompany.proyecto.service.MarcaService;

/**
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class MarcaServiceImpl implements MarcaService {
	
	private MarcaRepository marcaRepository;
	
	@Autowired
	public MarcaServiceImpl(MarcaRepository cr){
		this.marcaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Marca findById(Long codigo) throws DataAccessException {
		return marcaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findByName(String nombre) throws DataAccessException {
		return marcaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Marca b) throws DataAccessException {
		marcaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Marca> getAll() throws DataAccessException {
		return marcaRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Marca c) throws DataAccessException {
		marcaRepository.remove(c);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Marca> findByCombo() throws DataAccessException {
		return marcaRepository.findByCombo();
	}

}
