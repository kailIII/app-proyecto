package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Cheque;
import com.mycompany.proyecto.repository.ChequeRepository;
import com.mycompany.proyecto.service.ChequeService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ChequeServiceImpl implements ChequeService {
	
	private ChequeRepository chequeRepository;
	
	@Autowired
	public ChequeServiceImpl(ChequeRepository cr){
		this.chequeRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Cheque findById(Long codigo) throws DataAccessException {
		return chequeRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cheque> findByName(String nombre) throws DataAccessException {
		return chequeRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Cheque b) throws DataAccessException {
		chequeRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cheque> getAll() throws DataAccessException {
		return chequeRepository.findAll();
	}

	@Override
	public Boolean remove(Cheque c) throws DataAccessException {
		chequeRepository.remove(c);
		return true;
	}

}
