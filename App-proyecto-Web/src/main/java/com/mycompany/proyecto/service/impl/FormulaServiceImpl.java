package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Formula;
import com.mycompany.proyecto.repository.FormulaRepository;
import com.mycompany.proyecto.service.FormulaService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 * @author rodrigo garcete Fecha Creacion:21-11-2012
 */
@Service
public class FormulaServiceImpl implements FormulaService {

	private FormulaRepository formulaRepository;

	@Autowired
	public FormulaServiceImpl(FormulaRepository cr) {
		this.formulaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Formula findById(Long codigo) throws DataAccessException {
		return formulaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Formula> findByName(String nombre) throws DataAccessException {
		return formulaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Formula b) throws DataAccessException {
		formulaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Formula> getAll() throws DataAccessException {
		return formulaRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Formula f) throws DataAccessException {
		return formulaRepository.remove(f);
	}

}