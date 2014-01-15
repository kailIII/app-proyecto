package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Clasificacion;
import com.mycompany.proyecto.repository.ClasificacionRepository;
import com.mycompany.proyecto.service.ClasificacionService;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ClasificacionServiceImpl implements ClasificacionService {
	
	private ClasificacionRepository clasificacionRepository;
	
	@Autowired
	public ClasificacionServiceImpl(ClasificacionRepository cr){
		this.clasificacionRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Clasificacion findById(Long codigo) throws DataAccessException {
		return clasificacionRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Clasificacion> findByName(String nombre) throws DataAccessException {
		return clasificacionRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Clasificacion b) throws DataAccessException {
		clasificacionRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Clasificacion> getAll() throws DataAccessException {
		return clasificacionRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Clasificacion c) throws DataAccessException {
		clasificacionRepository.remove(c);
		return true;
	}

}
