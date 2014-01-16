package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Ciudad;
import com.mycompany.proyecto.repository.CiudadRepository;

/**
 * Implementacion de JPA de la interfaz {@link CiudadRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaCiudadRepositoryImpl implements CiudadRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Ciudad findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Ciudad.findById");
        query.setParameter("codigo", codigo);
        return (Ciudad)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Ciudad.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Ciudad>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> getAll() throws DataAccessException {
		return (List<Ciudad>)em.createNamedQuery("Ciudad.findByAll").getResultList();
	}

	@Override
	public void save(Ciudad c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);	
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Ciudad c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findByCombo() throws DataAccessException {
		return (List<Ciudad>)em.createNamedQuery("Ciudad.findByCombo").getResultList();
	}

}