package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Producto;
import com.mycompany.proyecto.repository.ProductoRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ProductoServiceImpl implements ProductoService {
	
	private ProductoRepository productoRepository;
	
	@Autowired
	public ProductoServiceImpl(ProductoRepository ir){
		this.productoRepository = ir;
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long codigo) throws DataAccessException {
		return productoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByName(String nombre) throws DataAccessException {
		return productoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Producto p) throws DataAccessException {
		productoRepository.save(p);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getAll() throws DataAccessException {
		return productoRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Producto p) throws DataAccessException {
		productoRepository.remove(p);
		return true;
	}

}