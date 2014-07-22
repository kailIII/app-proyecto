package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.PedidoRepository;
import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.model.PedidoDetalle;
/**
 * Implementacion de JPA de la interfaz {@link PedidoRepository}
 * @author Rodrigo Garcete
 * @since 21-11-2013
 */
@Repository
public class JpaPedidoRepositoryImpl extends BaseDao<Pedido, Serializable> implements PedidoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findByName(String estado) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Pedido.findByEstado");
        query.setParameter("estado", estado + "%");
        return (List<Pedido>)query.getResultList();
	}
	
	@Override
	public void savePedido(Pedido pedido, List<PedidoDetalle> listaItems) throws DataAccessException {
		if(pedido.getCodigo() == null){  
			this.entityManager.persist(pedido);
		}else {
			this.entityManager.merge(pedido);
		}
		
		
		if (listaItems != null && listaItems.size() > 0) {
			for (PedidoDetalle pd : listaItems) {
				//Le pasamos el Id del pedido del objeto persistente
				pd.getPedido().setCodigo(pedido.getCodigo());
				//verificamos si la entidad esta administrado
				this.entityManager.persist(entityManager.contains(pd) ? pd : entityManager.merge(pd));
			}
		}
		this.entityManager.flush();
		//limpiamos la lista
		listaItems.clear(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PedidoDetalle> findPedidoDetalles(Long codigo)
			throws DataAccessException {
		Query query = this.entityManager.createQuery("SELECT i FROM PedidoDetalle i WHERE i.pedido =:codigo");
        query.setParameter("codigo", codigo);
		
		return query.getResultList();
	}

}