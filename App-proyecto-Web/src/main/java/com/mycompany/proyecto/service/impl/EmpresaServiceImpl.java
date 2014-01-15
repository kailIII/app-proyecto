package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Empresa;
import com.mycompany.proyecto.repository.EmpresaRepository;
import com.mycompany.proyecto.service.EmpresaService;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private EmpresaRepository empresaRepository;
	
	@Autowired
	public EmpresaServiceImpl(EmpresaRepository cr){
		this.empresaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findById(Long codigo) throws DataAccessException {
		return empresaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findByName(String nombre) throws DataAccessException {
		return empresaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Empresa b) throws DataAccessException {
		empresaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empresa> getAll() throws DataAccessException {
		return empresaRepository.getAll();
	}

	@Override
	public Boolean remove(Empresa c) throws DataAccessException {
		empresaRepository.remove(c);
		return true;
	}

}
