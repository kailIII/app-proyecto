package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.TipoPersona;
import com.mycompany.proyecto.repository.TipoPersonaRepository;
/**
 * Implementacion de JPA de la interfaz {@link TipoPersonaRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaTipoPersonaRepositoryImpl implements TipoPersonaRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public TipoPersona findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("TipoPersona.findById");
        query.setParameter("codigo", codigo);
        return (TipoPersona)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPersona> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("TipoPersona.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<TipoPersona>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPersona> getAll() throws DataAccessException {
		return (List<TipoPersona>)em.createNamedQuery("TipoPersona.findByAll").getResultList();
	}

	@Override
	public void save(TipoPersona c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(TipoPersona t) throws DataAccessException {
		this.em.remove(em.contains(t) ? t : em.merge(t));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPersona> findByCombo() throws DataAccessException {
		return (List<TipoPersona>)em.createNamedQuery("TipoPersona.findByCombo").getResultList();
	}
}