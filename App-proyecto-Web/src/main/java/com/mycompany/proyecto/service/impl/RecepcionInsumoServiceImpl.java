package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.RecepcionInsumoRepository;
import com.mycompany.proyecto.model.RecepcionInsumo;
import com.mycompany.proyecto.service.RecepcionInsumoService;
/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class RecepcionInsumoServiceImpl implements RecepcionInsumoService {
	
	private RecepcionInsumoRepository recepcionInsumoRepository;
	
	@Autowired
	public RecepcionInsumoServiceImpl(RecepcionInsumoRepository cr){
		this.recepcionInsumoRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public RecepcionInsumo findById(Long codigo) throws DataAccessException {
		return recepcionInsumoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RecepcionInsumo> findByName(String nombre) throws DataAccessException {
		return recepcionInsumoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(RecepcionInsumo b) throws DataAccessException {
		recepcionInsumoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RecepcionInsumo> getAll() throws DataAccessException {
		return recepcionInsumoRepository.findAll();
	}

	@Override
	public Boolean remove(RecepcionInsumo c) throws DataAccessException {
		recepcionInsumoRepository.remove(c);
		return true;
	}

}