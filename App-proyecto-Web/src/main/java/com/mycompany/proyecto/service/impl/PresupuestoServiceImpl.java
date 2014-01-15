package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Presupuesto;
import com.mycompany.proyecto.repository.PresupuestoRepository;
import com.mycompany.proyecto.service.PresupuestoService;
/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class PresupuestoServiceImpl implements PresupuestoService {
	
	private PresupuestoRepository presRepository;
	
	@Autowired
	public PresupuestoServiceImpl(PresupuestoRepository ir){
		this.presRepository = ir;
	}

	@Override
	@Transactional(readOnly = true)
	public Presupuesto findById(Long codigo) throws DataAccessException {
		return presRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Presupuesto> findByName(String nombre) throws DataAccessException {
		return presRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Presupuesto p) throws DataAccessException {
		presRepository.save(p);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Presupuesto> getAll() throws DataAccessException {
		return presRepository.getAll();
	}

	@Override
	public Boolean remove(Presupuesto p) throws DataAccessException {
		presRepository.remove(p);
		return true;
	}

}