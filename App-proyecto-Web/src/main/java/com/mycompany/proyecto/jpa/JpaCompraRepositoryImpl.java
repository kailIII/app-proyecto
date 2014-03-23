package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Compra;
import com.mycompany.proyecto.model.CompraDetalle;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.CompraRepository;
/**
 * Implementacion de JPA de la interfaz {@link CompraRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaCompraRepositoryImpl extends BaseDao<Compra, Serializable> implements CompraRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Compra.findByEstado");
        query.setParameter("nombre", nombre + "%");
        return (List<Compra>)query.getResultList();
	}
	
	@Override
	public void save(Compra compra, ArrayList<CompraDetalle> items)
			throws DataAccessException {
		if (compra.getCodigo() == null) {
			this.entityManager.persist(compra);
		} else {
			this.entityManager.merge(compra);
		}
		
		if (items != null && items.size() > 0) {
			for (CompraDetalle cd : items) {
				//Le pasamos el Id del pedido del objeto persistente
				cd.getCompra().setCodigo(compra.getCodigo());
				//verificamos si la entidad esta administrado
				this.entityManager.persist(entityManager.contains(cd) ? cd : entityManager.merge(cd));
			}
		}
	}

}