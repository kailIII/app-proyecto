package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.EstadoCivilRepository;
import com.mycompany.proyecto.model.EstadoCivil;
/**
 * Implementacion de JPA de la interfaz {@link EstadoCivilRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaEstadoCivilRepositoryImpl extends BaseDao<EstadoCivil, Serializable> implements EstadoCivilRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoCivil> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT c FROM EstadoCivil c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<EstadoCivil>)query.getResultList();
	}

}