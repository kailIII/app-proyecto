package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.config.SearchCriteria;
import com.mycompany.proyecto.model.Pais;
import com.mycompany.proyecto.repository.PaisRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class PaisServiceImpl implements PaisService {
	
	private PaisRepository paisRepository;
	
	@Autowired
	public PaisServiceImpl(PaisRepository cr){
		this.paisRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Pais findById(Long codigo) throws DataAccessException {
		return paisRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pais> findByName(String nombre) throws DataAccessException {
		return paisRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Pais b) throws DataAccessException {
		paisRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pais> getAll() throws DataAccessException {
		return paisRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Pais c) throws DataAccessException {
		paisRepository.remove(c);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pais> findPaises(SearchCriteria criteria)
			throws DataAccessException {
		return paisRepository.findPais(criteria);
	}

}
