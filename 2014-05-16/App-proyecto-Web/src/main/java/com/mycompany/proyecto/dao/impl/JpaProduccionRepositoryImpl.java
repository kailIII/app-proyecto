package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.ProduccionRepository;
import com.mycompany.proyecto.model.Produccion;
/**
 * Implementacion de JPA de la interfaz {@link ProduccionRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaProduccionRepositoryImpl extends BaseDao<Produccion, Serializable> implements ProduccionRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produccion> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Produccion.findByEstado");
        query.setParameter("nombre", nombre + "%");
        return (List<Produccion>)query.getResultList();
	}

}