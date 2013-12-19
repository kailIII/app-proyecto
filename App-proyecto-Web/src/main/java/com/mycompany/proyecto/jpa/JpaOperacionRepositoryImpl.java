package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Operacion;
import com.mycompany.proyecto.repository.OperacionRepository;

/**
 * Implementacion de JPA de la interfaz {@link InusmoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaOperacionRepositoryImpl implements OperacionRepository {
	
	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Operacion findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT p FROM Operacion p WHERE p.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Operacion) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operacion> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT i FROM Operacion i WHERE i.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Operacion>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Operacion> getAll() throws DataAccessException {
		return (List<Operacion>)em.createQuery("select i from Operacion i order by i.codigo").getResultList();
	}

	@Override
	public void save(Operacion o) throws DataAccessException {
    	this.em.merge(o);
	}

	@Override
	public Boolean remove(Operacion o) throws DataAccessException {
		this.em.remove(o);
		return true;
	}

}