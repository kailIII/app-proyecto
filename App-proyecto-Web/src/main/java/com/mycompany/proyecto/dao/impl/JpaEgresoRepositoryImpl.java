package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.EgresoRepository;
import com.mycompany.proyecto.model.Egreso;
/**
 * Implementacion de JPA de la interfaz {@link EgresoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaEgresoRepositoryImpl extends BaseDao<Egreso, Serializable> implements EgresoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Egreso> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT c FROM Egreso c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Egreso>)query.getResultList();
	}
	
}