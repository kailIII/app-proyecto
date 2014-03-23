package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Cuenta;
import com.mycompany.proyecto.repository.CuentaRepository;
import com.mycompany.proyecto.service.CuentaService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class CuentaServiceImpl implements CuentaService {
	
	private CuentaRepository cuentaRepository;
	
	@Autowired
	public CuentaServiceImpl(CuentaRepository cr){
		this.cuentaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findById(Long codigo) throws DataAccessException {
		return cuentaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findByName(String nombre) throws DataAccessException {
		return cuentaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Cuenta b) throws DataAccessException {
		cuentaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> getAll() throws DataAccessException {
		return cuentaRepository.findAll();
	}

	@Override
	public Boolean remove(Cuenta c) throws DataAccessException {
		cuentaRepository.remove(c);
		return true;
	}

}
