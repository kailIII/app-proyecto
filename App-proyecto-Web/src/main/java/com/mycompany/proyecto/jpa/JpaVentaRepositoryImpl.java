package com.mycompany.proyecto.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Venta;
import com.mycompany.proyecto.model.VentaDetalle;
import com.mycompany.proyecto.repository.VentaRepository;
/**
 * Implementacion de JPA de la interfaz {@link VentaRepository}
 * @author Rodrigo Garcete
 * @since 22/01/2014
 */
@Repository
public class JpaVentaRepositoryImpl implements VentaRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Venta findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Venta.findById");
        query.setParameter("codigo", codigo);
        return (Venta)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Venta.findByEstado");
        query.setParameter("estado", nombre + "%");
        return (List<Venta>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> getAll() throws DataAccessException {
		return (List<Venta>)em.createNamedQuery("Venta.findByAll").getResultList();
	}

	@Override
	public void save(Venta c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Venta c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@Override
	public void save(Venta v, ArrayList<VentaDetalle> items)
			throws DataAccessException {
		if (v.getCodigo() == null) {
			this.em.persist(v);
		} else {
			this.em.merge(v);
		}
		
		if (items != null && items.size() > 0) {
			for (VentaDetalle vd : items) {
				//Le pasamos el Id del pedido del objeto persistente
				vd.getVenta().setCodigo(v.getCodigo());
				//verificamos si la entidad esta administrado
				this.em.persist(em.contains(vd) ? vd : em.merge(vd));
			}
		}
	}

}