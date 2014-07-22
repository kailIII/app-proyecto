package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.PaisRepository;
import com.mycompany.proyecto.model.Pais;
/**
 * Implementacion de JPA de la interfaz {@link PaisRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaPaisRepositoryImpl extends BaseDao<Pais, Serializable> implements PaisRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Pais.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Pais>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findByCombo() throws DataAccessException {
		return (List<Pais>)entityManager.createNamedQuery("Pais.findByCombo").getResultList();
	}

}