package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Egreso;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.EgresoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaEgresoRepositoryImpl implements EgresoRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Egreso findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM Egreso c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Egreso)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Egreso> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM Egreso c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Egreso>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Egreso> getAll() throws DataAccessException {
		return (List<Egreso>)em.createQuery("SELECT c FROM Egreso c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(Egreso c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Egreso c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}