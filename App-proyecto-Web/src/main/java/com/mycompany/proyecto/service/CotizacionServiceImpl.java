package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Cotizacion;
import com.mycompany.proyecto.repository.CotizacionRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class CotizacionServiceImpl implements CotizacionService {
	
	private CotizacionRepository cotizacionRepository;
	
	@Autowired
	public CotizacionServiceImpl(CotizacionRepository cr){
		this.cotizacionRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Cotizacion findById(Long codigo) throws DataAccessException {
		return cotizacionRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cotizacion> findByName(String nombre) throws DataAccessException {
		return cotizacionRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Cotizacion b) throws DataAccessException {
		cotizacionRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cotizacion> getAll() throws DataAccessException {
		return cotizacionRepository.getAll();
	}

	@Override
	public Boolean remove(Cotizacion c) throws DataAccessException {
		cotizacionRepository.remove(c);
		return true;
	}

}
