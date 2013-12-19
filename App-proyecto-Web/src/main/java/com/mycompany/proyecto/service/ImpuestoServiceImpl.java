package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Impuesto;
import com.mycompany.proyecto.repository.ImpuestoRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ImpuestoServiceImpl implements ImpuestoService {
	
	private ImpuestoRepository impuestoRepository;
	
	@Autowired
	public ImpuestoServiceImpl(ImpuestoRepository cr){
		this.impuestoRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Impuesto findById(Long codigo) throws DataAccessException {
		return impuestoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Impuesto> findByName(String nombre) throws DataAccessException {
		return impuestoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Impuesto b) throws DataAccessException {
		impuestoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Impuesto> getAll() throws DataAccessException {
		return impuestoRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Impuesto c) throws DataAccessException {
		impuestoRepository.remove(c);
		return true;
	}

}
