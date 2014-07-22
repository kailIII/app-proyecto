package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.dao.ClienteRepository;
import com.mycompany.proyecto.model.Cliente;
/**
 * Implementacion de JPA de la interfaz {@link ClienteRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaClienteRepositoryImpl extends BaseDao<Cliente, Serializable> implements ClienteRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Cliente.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Cliente>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByCombo() throws DataAccessException {
		return (List<Cliente>)entityManager.createNamedQuery("Cliente.findByCombo").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return entityManager.createNamedQuery("Cliente.findByAll").getResultList();
	}

}