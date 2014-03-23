package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Ciudad;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.CiudadRepository;

/**
 * Implementacion de JPA de la interfaz {@link CiudadRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaCiudadRepositoryImpl extends BaseDao<Ciudad, Serializable> implements CiudadRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Ciudad.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Ciudad>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findByCombo() throws DataAccessException {
		return (List<Ciudad>)entityManager.createNamedQuery("Ciudad.findByCombo").getResultList();
	}

}