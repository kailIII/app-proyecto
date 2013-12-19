package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Cliente;
import com.mycompany.proyecto.repository.ClienteRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
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
		return clienteRepository.getAll();
	}

	@Override
	public Boolean remove(Cliente c) throws DataAccessException {
		clienteRepository.remove(c);
		return true;
	}

}
