package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Usuario;
import com.mycompany.proyecto.repository.UsuarioRepository;
import com.mycompany.proyecto.service.UsuarioService;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class UsuarioSeviceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioSeviceImpl(UsuarioRepository ur){
		this.usuarioRepository = ur;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long codigo) throws DataAccessException {
		return usuarioRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByName(String nombre) throws DataAccessException {
		return usuarioRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Usuario u) throws DataAccessException {
		usuarioRepository.save(u);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> getAll() throws DataAccessException {
		return usuarioRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Usuario u) throws DataAccessException {
		usuarioRepository.remove(u);
		return null;
	}

}