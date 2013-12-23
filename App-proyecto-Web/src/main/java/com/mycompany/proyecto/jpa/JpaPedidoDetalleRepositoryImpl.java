package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.PedidoDetalle;
import com.mycompany.proyecto.repository.PedidoDetalleRepository;

/**
 * Implementacion de JPA de la interfaz {@link PedidoDetalleRepository}
 * @author Rodrigo Garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaPedidoDetalleRepositoryImpl implements PedidoDetalleRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public PedidoDetalle findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM PedidoDetalle b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (PedidoDetalle)query.getSingleResult();
	}

	@Override
	public void save(List<PedidoDetalle> pDetalle) throws DataAccessException {
		if (pDetalle != null && pDetalle.size() > 0) {
			for (PedidoDetalle pd : pDetalle) {
				this.em.persist(pd);
				this.em.flush();
			}
		}
	}

	@Override
	public Boolean remove(PedidoDetalle pDetalle) throws DataAccessException {
		this.em.remove(em.contains(pDetalle) ? pDetalle : em.merge(pDetalle));
		return true;
	}

}