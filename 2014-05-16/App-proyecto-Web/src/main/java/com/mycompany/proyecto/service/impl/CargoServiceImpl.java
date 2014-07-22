package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.CargoRepository;
import com.mycompany.proyecto.model.Cargo;
import com.mycompany.proyecto.service.CargoService;

/**
 * Implementacion de Servicio para la Entidad
 * Cargo
 * @author Rodrigo Garcete
 * @since 21/11/2012
 */
@Service
public class CargoServiceImpl implements CargoService {
	
	private CargoRepository cargoRepository;
	
	@Autowired
	public CargoServiceImpl(CargoRepository cr){
		this.cargoRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo findById(Long codigo) throws DataAccessException {
		return cargoRepository.findById(codigo);
	}

//	@Override
//	@Transactional(readOnly = true)
//	public List<Cargo> findByName(String nombre) throws DataAccessException {
//		return cargoRepository.findByName(nombre);
//	}

	@Override
	@Transactional
	public void save(Cargo b) throws DataAccessException {
		cargoRepository.save(b);
	}

//	@Override
//	@Transactional(readOnly = true)
//	public Collection<Cargo> getAll() throws DataAccessException {
//		return cargoRepository.findAll();
//	}

	@Override
	@Transactional
	public Boolean remove(Cargo c) throws DataAccessException {
		cargoRepository.remove(c);
		return true;
	}

//	@Override
//	public List<Cargo> findByCombo() throws DataAccessException {
//		return cargoRepository.findByCombo();
//	}

	@Override
	public List<Cargo> findByName(String nombre) throws DataAccessException {
		return null;
	}

	@Override
	public List<Cargo> getAll() throws DataAccessException {
		return cargoRepository.findAll();
	}

	@Override
	public List<Cargo> findByCombo() throws DataAccessException {
		return null;
	}

}
