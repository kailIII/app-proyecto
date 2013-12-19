package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.UnidadMedida;
import com.mycompany.proyecto.repository.UnidadMedidaRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class UnidadMedidaSeviceImpl implements UnidadMedidaService {
	
	private UnidadMedidaRepository umRepository;
	
	@Autowired
	public UnidadMedidaSeviceImpl(UnidadMedidaRepository ir){
		this.umRepository = ir;
	}

	@Override
	@Transactional(readOnly = true)
	public UnidadMedida findById(Long codigo) throws DataAccessException {
		return umRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UnidadMedida> findByName(String nombre) throws DataAccessException {
		return umRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(UnidadMedida um) throws DataAccessException {
		umRepository.save(um);
	}

	@Override
	@Transactional (readOnly = true)
	public List<UnidadMedida> getAll() throws DataAccessException {
		return umRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(UnidadMedida um) throws DataAccessException {
		umRepository.remove(um);
		return true;
	}

}
