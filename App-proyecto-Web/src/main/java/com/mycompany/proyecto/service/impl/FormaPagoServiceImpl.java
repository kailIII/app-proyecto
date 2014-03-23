package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.FormaPago;
import com.mycompany.proyecto.repository.FormaPagoRepository;
import com.mycompany.proyecto.service.FormaPagoService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class FormaPagoServiceImpl implements FormaPagoService {
	
	private FormaPagoRepository foRepository;
	
	@Autowired
	public FormaPagoServiceImpl(FormaPagoRepository cr){
		this.foRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public FormaPago findById(Long codigo) throws DataAccessException {
		return foRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FormaPago> findByName(String nombre) throws DataAccessException {
		return foRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(FormaPago b) throws DataAccessException {
		foRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FormaPago> getAll() throws DataAccessException {
		return foRepository.findAll();
	}

	@Override
	public Boolean remove(FormaPago c) throws DataAccessException {
		foRepository.remove(c);
		return true;
	}

}
