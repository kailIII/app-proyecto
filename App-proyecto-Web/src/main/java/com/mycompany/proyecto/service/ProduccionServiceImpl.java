package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Produccion;
import com.mycompany.proyecto.repository.ProduccionRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ProduccionServiceImpl implements ProduccionService {
	
	private ProduccionRepository produccionRepository;
	
	@Autowired
	public ProduccionServiceImpl(ProduccionRepository cr){
		this.produccionRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Produccion findById(Long codigo) throws DataAccessException {
		return produccionRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produccion> findByName(String nombre) throws DataAccessException {
		return produccionRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Produccion b) throws DataAccessException {
		produccionRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produccion> getAll() throws DataAccessException {
		return produccionRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Produccion c) throws DataAccessException {
		produccionRepository.remove(c);
		return true;
	}

}
