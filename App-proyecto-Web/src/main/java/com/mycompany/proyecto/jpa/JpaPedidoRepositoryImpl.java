package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Insumo;
import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.model.PedidoDetalle;
import com.mycompany.proyecto.repository.PedidoRepository;

/**
 * Implementacion de JPA de la interfaz {@link PedidoRepository}
 * @author Rodrigo Garcete
 * @since 21-11-2013
 */
@Repository
public class JpaPedidoRepositoryImpl implements PedidoRepository {
	
	@PersistenceContext
	private EntityManager em;


    @Override
	public Pedido findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Pedido b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Pedido)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Pedido b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Pedido>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> getAll() throws DataAccessException {
		return (List<Pedido>)em.createQuery("SELECT p FROM Pedido p order by p.codigo").getResultList();
	}

	@Override
	public void save(Pedido c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);	
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Pedido c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insumo> getInsumos() throws DataAccessException {
		Query query = this.em.createQuery("FROM Insumo");
        return (List<Insumo>)query.getResultList();
	}

	@Override
	public void savePedido(Pedido pedido, List<PedidoDetalle> listaItems) throws DataAccessException {
		if(pedido.getCodigo() == null){
			this.em.persist(pedido);
		}else {
			this.em.merge(pedido);
		}
		
		
		if (listaItems != null && listaItems.size() > 0) {
			for (PedidoDetalle pd : listaItems) {
				//Le pasamos el Id del pedido del objeto persistente
				pd.getPedido().setCodigo(pedido.getCodigo());
				//verificamos si la entidad esta administrado
				this.em.persist(em.contains(pd) ? pd : em.merge(pd));
			}
		}
		this.em.flush();
		//limpiamos la lista
		listaItems.clear(); 
	}

	@Override
	public List<PedidoDetalle> findPedidoDetalles(Long codigo)
			throws DataAccessException {
		
		Query query = this.em.createQuery("SELECT i FROM PedidoDetalle i WHERE i.pedido =:codigo");
        query.setParameter("codigo", codigo);
		
		return query.getResultList();
	}

}