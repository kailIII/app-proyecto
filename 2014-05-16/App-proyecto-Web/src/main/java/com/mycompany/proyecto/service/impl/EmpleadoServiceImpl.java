package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.EmpleadoRepository;
import com.mycompany.proyecto.model.Empleado;
import com.mycompany.proyecto.service.EmpleadoService;

/**
 * Implementacion de la capa de Servicio para 
 * la entidad Empleado
 *
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	public EmpleadoServiceImpl(EmpleadoRepository cr){
		this.empleadoRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long codigo) throws DataAccessException {
		return empleadoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findByName(String nombre) throws DataAccessException {
		return empleadoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Empleado b) throws DataAccessException {
		empleadoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> getAll() throws DataAccessException {
		return empleadoRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Empleado c) throws DataAccessException {
		empleadoRepository.remove(c);
		return true;
	}

	@Override
	public List<Empleado> findByCombo() throws DataAccessException {
		return empleadoRepository.findByCombo();
	}
}