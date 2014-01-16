package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Lote;
import com.mycompany.proyecto.repository.LoteRepository;
/**
 * Implementacion de JPA de la interfaz {@link LoteRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaLoteRepositoryImpl implements LoteRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Lote findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Lote.findById");
        query.setParameter("codigo", codigo);
        return (Lote)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lote> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Lote.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Lote>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lote> getAll() throws DataAccessException {
		return (List<Lote>)em.createNamedQuery("Lote.findByAll").getResultList();
	}

	@Override
	public void save(Lote l) throws DataAccessException {
		if(l.getCodigo() == null){
			this.em.persist(l);
		}else {
			this.em.merge(l);	
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Lote l) throws DataAccessException {
		this.em.remove(em.contains(l) ? l : em.merge(l));
		return true;
	}

}