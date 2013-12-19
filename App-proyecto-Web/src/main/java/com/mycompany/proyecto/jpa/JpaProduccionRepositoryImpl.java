package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Produccion;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.ProduccionRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaProduccionRepositoryImpl implements ProduccionRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Produccion findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Produccion b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Produccion)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produccion> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM Produccion b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Produccion>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produccion> getAll() throws DataAccessException {
		return (List<Produccion>)em.createQuery("SELECT b FROM Produccion b order by b.codigo").getResultList();
	}

	@Override
	public void save(Produccion c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Produccion c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}