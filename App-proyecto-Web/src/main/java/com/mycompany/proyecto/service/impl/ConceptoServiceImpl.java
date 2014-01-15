package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Concepto;
import com.mycompany.proyecto.repository.ConceptoRepository;
import com.mycompany.proyecto.service.ConceptoService;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ConceptoServiceImpl implements ConceptoService {
	
	private ConceptoRepository conceptoRepository;
	
	@Autowired
	public ConceptoServiceImpl(ConceptoRepository cr){
		this.conceptoRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Concepto findById(Long codigo) throws DataAccessException {
		return conceptoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Concepto> findByName(String nombre) throws DataAccessException {
		return conceptoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Concepto b) throws DataAccessException {
		conceptoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Concepto> getAll() throws DataAccessException {
		return conceptoRepository.getAll();
	}

	@Override
	public Boolean remove(Concepto c) throws DataAccessException {
		conceptoRepository.remove(c);
		return true;
	}

}
