package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Produccion;
import com.mycompany.proyecto.repository.ProduccionRepository;
/**
 * Implementacion de JPA de la interfaz {@link ProduccionRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaProduccionRepositoryImpl implements ProduccionRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Produccion findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Produccion.findById");
        query.setParameter("codigo", codigo);
        return (Produccion)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produccion> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Produccion.findByEstado");
        query.setParameter("nombre", nombre + "%");
        return (List<Produccion>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produccion> getAll() throws DataAccessException {
		return (List<Produccion>)em.createNamedQuery("Produccion.findByAll").getResultList();
	}

	@Override
	public void save(Produccion c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Produccion c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}