package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Cliente;
import com.mycompany.proyecto.repository.ClienteRepository;
import com.mycompany.proyecto.service.ClienteService;

/**
 * Implementacion de los servicios para la 
 * entidad Cliente
 *
 * @author Rodrigo Garcete
 * @since 21/11/2012
 */
@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteServiceImpl(ClienteRepository cr){
		this.clienteRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long codigo) throws DataAccessException {
		return clienteRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByName(String nombre) throws DataAccessException {
		return clienteRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Cliente b) throws DataAccessException {
		clienteRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> getAll() throws DataAccessException {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Cliente c) throws DataAccessException {
		clienteRepository.remove(c);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByCombo() throws DataAccessException {
		return clienteRepository.findByCombo();
	}
}