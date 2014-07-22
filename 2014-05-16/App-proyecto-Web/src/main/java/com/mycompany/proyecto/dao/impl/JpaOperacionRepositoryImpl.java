package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.OperacionRepository;
import com.mycompany.proyecto.model.Operacion;
/**
 * Implementacion de JPA de la interfaz {@link OperacionRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaOperacionRepositoryImpl extends BaseDao<Operacion, Serializable> implements OperacionRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Operacion> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT i FROM Operacion i WHERE i.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Operacion>)query.getResultList();
	}

}