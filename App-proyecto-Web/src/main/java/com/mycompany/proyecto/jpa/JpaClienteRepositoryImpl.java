package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Cliente;
import com.mycompany.proyecto.repository.ClienteRepository;
/**
 * Implementacion de JPA de la interfaz {@link ClienteRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaClienteRepositoryImpl implements ClienteRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Cliente findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Cliente.findById");
        query.setParameter("codigo", codigo);
        return (Cliente)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Cliente.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Cliente>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getAll() throws DataAccessException {
		return (List<Cliente>)em.createNamedQuery("Cliente.findByAll").getResultList();
	}

	@Override
	public void save(Cliente c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	@Transactional
	public Boolean remove(Cliente c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByCombo() throws DataAccessException {
		return (List<Cliente>)em.createNamedQuery("Cliente.findByCombo").getResultList();
	}

}