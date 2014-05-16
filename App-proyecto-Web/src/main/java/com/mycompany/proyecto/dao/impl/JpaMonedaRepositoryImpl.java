package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.MonedaRepository;
import com.mycompany.proyecto.model.Moneda;
/**
 * Implementacion de JPA de la interfaz {@link MonedaRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaMonedaRepositoryImpl extends BaseDao<Moneda , Serializable> implements MonedaRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Moneda> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Moneda b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Moneda>)query.getResultList();
	}

}