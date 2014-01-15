package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Moneda;
import com.mycompany.proyecto.repository.MonedaRepository;
import com.mycompany.proyecto.service.MonedaService;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class MonedaServiceImpl implements MonedaService {
	
	private MonedaRepository monedaRepository;
	
	@Autowired
	public MonedaServiceImpl(MonedaRepository cr){
		this.monedaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Moneda findById(Long codigo) throws DataAccessException {
		return monedaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Moneda> findByName(String nombre) throws DataAccessException {
		return monedaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Moneda b) throws DataAccessException {
		monedaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Moneda> getAll() throws DataAccessException {
		return monedaRepository.getAll();
	}

	@Override
	public Boolean remove(Moneda c) throws DataAccessException {
		monedaRepository.remove(c);
		return true;
	}

}
