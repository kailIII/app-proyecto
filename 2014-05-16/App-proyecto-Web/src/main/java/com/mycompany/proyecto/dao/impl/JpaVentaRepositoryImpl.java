package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.VentaRepository;
import com.mycompany.proyecto.model.Venta;
import com.mycompany.proyecto.model.VentaDetalle;
/**
 * Implementacion de JPA de la interfaz {@link VentaRepository}
 * @author Rodrigo Garcete
 * @since 22/01/2014
 */
@Repository
public class JpaVentaRepositoryImpl extends BaseDao<Venta, Serializable> implements VentaRepository {
	
	@Override
	public void save(Venta v, ArrayList<VentaDetalle> items)
			throws DataAccessException {
		if (v.getCodigo() == null) {
			this.entityManager.persist(v);
		} else {
			this.entityManager.merge(v);
		}
		
		if (items != null && items.size() > 0) {
			for (VentaDetalle vd : items) {
				//Le pasamos el Id del pedido del objeto persistente
				vd.getVenta().setCodigo(v.getCodigo());
				//verificamos si la entidad esta administrado
				this.entityManager.persist(entityManager.contains(vd) ? vd : entityManager.merge(vd));
			}
		}
		this.entityManager.flush();
	}

}