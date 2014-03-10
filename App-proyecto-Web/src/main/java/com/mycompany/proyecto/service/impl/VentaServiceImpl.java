package com.mycompany.proyecto.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Venta;
import com.mycompany.proyecto.model.VentaDetalle;
import com.mycompany.proyecto.repository.VentaRepository;
import com.mycompany.proyecto.service.VentaService;
/**
 * Implementacion de la capa de servicios para
 * la entidad Venta
 *
 * @author Rodrigo Garcete
 * @since 22/01/2014
 */
@Service
public class VentaServiceImpl implements VentaService {
	
	private VentaRepository ventaRepository;
	
	@Autowired
	public VentaServiceImpl(VentaRepository cr){
		this.ventaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Venta findById(Long codigo) throws DataAccessException {
		return ventaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Venta> findByName(String nombre) throws DataAccessException {
		return ventaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Venta b) throws DataAccessException {
		ventaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Venta> getAll() throws DataAccessException {
		return ventaRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Venta c) throws DataAccessException {
		ventaRepository.remove(c);
		return true;
	}

	@Override
	public void save(Venta v, ArrayList<VentaDetalle> items)
			throws DataAccessException {
		ventaRepository.save(v, items);	
	}

}