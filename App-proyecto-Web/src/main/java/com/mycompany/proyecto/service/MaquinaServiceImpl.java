package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Maquina;
import com.mycompany.proyecto.repository.MaquinaRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class MaquinaServiceImpl implements MaquinaService {
	
	private MaquinaRepository maquinaRepository;
	
	@Autowired
	public MaquinaServiceImpl(MaquinaRepository cr){
		this.maquinaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Maquina findById(Long codigo) throws DataAccessException {
		return maquinaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Maquina> findByName(String nombre) throws DataAccessException {
		return maquinaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Maquina b) throws DataAccessException {
		maquinaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Maquina> getAll() throws DataAccessException {
		return maquinaRepository.getAll();
	}

	@Override
	public Boolean remove(Maquina c) throws DataAccessException {
		maquinaRepository.remove(c);
		return true;
	}

}
