package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.PresupuestoRepository;
import com.mycompany.proyecto.model.Presupuesto;
/**
 * Implementacion de JPA de la interfaz {@link PresupuestoRepository}
 * 
 * @author rodrigo garcete Fecha Creacion:21-11-2013
 */
@Repository
public class JpaPresupuestoRepositoryImpl extends BaseDao<Presupuesto, Serializable> implements PresupuestoRepository {


	@SuppressWarnings("unchecked")
	@Override
	public List<Presupuesto> findByName(String nombre)
			throws DataAccessException {
		Query query = this.entityManager.createQuery("SELECT b FROM Presupuesto b WHERE b.nombre LIKE :nombre");
		query.setParameter("nombre", nombre + "%");
		return (List<Presupuesto>) query.getResultList();
	}
}