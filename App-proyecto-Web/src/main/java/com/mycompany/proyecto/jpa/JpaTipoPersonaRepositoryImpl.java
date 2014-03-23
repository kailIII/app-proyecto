package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.TipoPersona;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.TipoPersonaRepository;
/**
 * Implementacion de JPA de la interfaz {@link TipoPersonaRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaTipoPersonaRepositoryImpl extends BaseDao<TipoPersona, Serializable> implements TipoPersonaRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPersona> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("TipoPersona.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<TipoPersona>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPersona> findByCombo() throws DataAccessException {
		return (List<TipoPersona>)entityManager.createNamedQuery("TipoPersona.findByCombo").getResultList();
	}
}