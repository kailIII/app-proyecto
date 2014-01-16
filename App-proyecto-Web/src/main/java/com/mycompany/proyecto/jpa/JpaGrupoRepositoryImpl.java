package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Grupo;
import com.mycompany.proyecto.repository.GrupoRepository;
/**
 * Implementacion de JPA de la interfaz {@link GrupoRepository}
 * @author Rodrigo Garcete
 * @since 21-11-2013
 */
@Repository
public class JpaGrupoRepositoryImpl implements GrupoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Grupo findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Grupo.findById");
        query.setParameter("codigo", codigo);
        return (Grupo)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Grupo.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Grupo>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> getAll() throws DataAccessException {
		return (List<Grupo>)em.createNamedQuery("Grupo.findByAll").getResultList();
	}

	@Override
	public void save(Grupo g) throws DataAccessException {
		if(g.getCodigo() == null){
			this.em.persist(g);
		}else {
			this.em.merge(g);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Grupo c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findByCombo() throws DataAccessException {
		return (List<Grupo>)em.createNamedQuery("Grupo.findByCombo").getResultList();
	}

}