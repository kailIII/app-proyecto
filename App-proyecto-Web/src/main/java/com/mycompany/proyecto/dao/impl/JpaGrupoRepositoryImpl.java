package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.GrupoRepository;
import com.mycompany.proyecto.model.Grupo;
/**
 * Implementacion de JPA de la interfaz {@link GrupoRepository}
 * @author Rodrigo Garcete
 * @since 21-11-2013
 */
@Repository
public class JpaGrupoRepositoryImpl extends BaseDao<Grupo, Serializable> implements GrupoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Grupo.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Grupo>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findByCombo() throws DataAccessException {
		return (List<Grupo>)entityManager.createNamedQuery("Grupo.findByCombo").getResultList();
	}

}