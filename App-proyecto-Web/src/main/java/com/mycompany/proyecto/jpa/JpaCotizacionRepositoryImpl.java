package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Cotizacion;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.CotizacionRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaCotizacionRepositoryImpl implements CotizacionRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Cotizacion findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Cotizacion b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Cotizacion)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cotizacion> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM Cotizacion b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Cotizacion>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cotizacion> getAll() throws DataAccessException {
		return (List<Cotizacion>)em.createQuery("SELECT b FROM Cotizacion b order by i.codigo").getResultList();
	}

	@Override
	public void save(Cotizacion c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Cotizacion c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}