package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Deposito;
import com.mycompany.proyecto.repository.DepositoRepository;
import com.mycompany.proyecto.service.DepositoService;

/**
 * Implementacion de la capa de Servicios para la 
 * entidad Deposito
 * @author Rodrigo Garcete
 * @since 21/11/2012
 */
@Service
public class DepositoServiceImpl implements DepositoService {
	
	private DepositoRepository depRepository;
	
	@Autowired
	public DepositoServiceImpl(DepositoRepository cr){
		this.depRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Deposito findById(Long codigo) throws DataAccessException {
		return depRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Deposito> findByName(String nombre) throws DataAccessException {
		return depRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Deposito b) throws DataAccessException {
		depRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Deposito> getAll() throws DataAccessException {
		return depRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Deposito                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    c) throws DataAccessException {
		depRepository.remove(c);
		return true;
	}

	@Override
	public List<Deposito> findByCombo() throws DataAccessException {
		return depRepository.findByCombo();
	}
}