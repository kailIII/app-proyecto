package com.mycompany.proyecto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Producto;
import com.mycompany.proyecto.repository.ProductoRepository;
import com.mycompany.proyecto.service.ProductoService;

/**
 * Servicio que implementa la Logica de Negocio del Caso de Uso Productos
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Service
public class ProductoSeviceImpl implements ProductoService {
	
	private ProductoRepository productoRepository;
	
	@Autowired
	public ProductoSeviceImpl(ProductoRepository ir){
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
		return productoRepository.findByName(nombre, 25);
	}

	@Override
	@Transactional
	public void save(Producto producto) throws DataAccessException {
		productoRepository.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getAll() throws DataAccessException {
		return productoRepository.getAll(25);
	}

	@Override
	@Transactional
	public Boolean remove(Producto producto) throws DataAccessException {
		productoRepository.remove(producto);
		return true;
	}

	@Override
	public List<Producto> findByCombo() throws DataAccessException {
		return productoRepository.findByCombo();
	}

	@Override
	public List<Producto> findByInsumo() throws DataAccessException {
		return productoRepository.findByInsumo();
	}
}