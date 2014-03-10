package com.mycompany.proyecto.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Compra;
import com.mycompany.proyecto.model.CompraDetalle;
import com.mycompany.proyecto.repository.CompraRepository;
/**
 * Implementacion de JPA de la interfaz {@link CompraRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaCompraRepositoryImpl implements CompraRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Compra findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Compra.findById");
        query.setParameter("codigo", codigo);
        return (Compra)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Compra.findByEstado");
        query.setParameter("nombre", nombre + "%");
        return (List<Compra>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> getAll() throws DataAccessException {
		return (List<Compra>)em.createNamedQuery("Compra.findByAll").getResultList();
	}

	@Override
	public void save(Compra c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Compra c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@Override
	public void save(Compra compra, ArrayList<CompraDetalle> items)
			throws DataAccessException {
		if (compra.getCodigo() == null) {
			this.em.persist(compra);
		} else {
			this.em.merge(compra);
		}
		
		if (items != null && items.size() > 0) {
			for (CompraDetalle cd : items) {
				//Le pasamos el Id del pedido del objeto persistente
				cd.getCompra().setCodigo(compra.getCodigo());
				//verificamos si la entidad esta administrado
				this.em.persist(em.contains(cd) ? cd : em.merge(cd));
			}
		}
	}

}