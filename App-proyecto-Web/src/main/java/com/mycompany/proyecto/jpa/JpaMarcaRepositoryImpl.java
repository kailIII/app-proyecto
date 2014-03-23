package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Marca;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.MarcaRepository;
/**
 * Implementacion de JPA de la interfaz {@link MarcaRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaMarcaRepositoryImpl extends BaseDao<Marca, Serializable> implements MarcaRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Marca.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Marca>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> findByCombo() throws DataAccessException {
		return (List<Marca>)entityManager.createNamedQuery("Marca.findByCombo").getResultList();
	}

}