package com.mycompany.proyecto.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Producto;
import com.mycompany.proyecto.repository.ProductoRepository;
import com.mycompany.proyecto.service.ProductoService;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ProductoSeviceImpl implements ProductoService {
	
	private ProductoRepository insumoRepository;
	
	@Autowired
	public ProductoSeviceImpl(ProductoRepository ir){
		this.insumoRepository = ir;
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long codigo) throws DataAccessException {
		return insumoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Producto> findByName(String nombre) throws DataAccessException {
		return insumoRepository.findByName(nombre, 25);
	}

	@Override
	@Transactional
	public void save(Producto insumo) throws DataAccessException {
		insumoRepository.save(insumo);
		//return insumo;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getAll() throws DataAccessException {
		return insumoRepository.getAll(25);
	}

	@Override
	@Transactional
	public Boolean remove(Producto insumo) throws DataAccessException {
		insumoRepository.remove(insumo);
		return null;
	}

}
