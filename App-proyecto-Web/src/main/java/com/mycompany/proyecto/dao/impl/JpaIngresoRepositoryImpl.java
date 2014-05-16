package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.IngresoRepository;
import com.mycompany.proyecto.model.Ingreso;
/**
 * Implementacion de JPA de la interfaz {@link IngresoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaIngresoRepositoryImpl extends BaseDao<Ingreso, Serializable> implements IngresoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingreso> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Ingreso b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Ingreso>)query.getResultList();
	}

}