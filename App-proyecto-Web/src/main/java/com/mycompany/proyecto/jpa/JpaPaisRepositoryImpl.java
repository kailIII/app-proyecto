package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.mycompany.proyecto.config.SearchCriteria;
import com.mycompany.proyecto.model.Pais;
import com.mycompany.proyecto.repository.PaisRepository;
/**
 * Implementacion de JPA de la interfaz {@link PaisRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaPaisRepositoryImpl implements PaisRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Pais findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Pais.findById");
        query.setParameter("codigo", codigo);
        return (Pais)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Pais.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Pais>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> getAll() throws DataAccessException {
		return (List<Pais>)em.createNamedQuery("Pais.findByAll").getResultList();
	}

	@Override
	public void save(Pais c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Pais c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}
	
	// helpers
	private String getSearchPattern(SearchCriteria criteria) {
		if (StringUtils.hasText(criteria.getSearchString())) {
			return "'%"
				+ criteria.getSearchString().toLowerCase()
					.replace('*', '%') + "%'";
		} else {
			return "'%'";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findPais(SearchCriteria criterio) throws DataAccessException {
		String pattern = getSearchPattern(criterio);
		return this.em.createQuery(
				"select p from Pais where lower(p.nombre) like " + pattern)
				.setMaxResults(criterio.getPageSize()).setFirstResult(criterio.getPage() * criterio.getPageSize())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findByCombo() throws DataAccessException {
		return (List<Pais>)em.createNamedQuery("Pais.findByCombo").getResultList();
	}

}