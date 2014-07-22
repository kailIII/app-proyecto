package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.IngresoRepository;
import com.mycompany.proyecto.model.Ingreso;
import com.mycompany.proyecto.service.IngresoService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class IngresoServiceImpl implements IngresoService {
	
	private IngresoRepository ingresoRepository;
	
	@Autowired
	public IngresoServiceImpl(IngresoRepository ir){
		this.ingresoRepository = ir;
	}

	@Override
	@Transactional(readOnly = true)
	public Ingreso findById(Long codigo) throws DataAccessException {
		return ingresoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ingreso> findByName(String nombre) throws DataAccessException {
		return ingresoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Ingreso b) throws DataAccessException {
		ingresoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ingreso> getAll() throws DataAccessException {
		return ingresoRepository.findAll();
	}

	@Override
	public Boolean remove(Ingreso c) throws DataAccessException {
		ingresoRepository.remove(c);
		return true;
	}

}
