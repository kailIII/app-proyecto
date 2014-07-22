package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.CargoRepository;
import com.mycompany.proyecto.model.Cargo;
/**
 * Implementacion de JPA de la interfaz {@link CargoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaCargoRepositoryImpl extends BaseDao<Cargo, Serializable> implements CargoRepository {

	@SuppressWarnings("unchecked")
	public List<Cargo> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Cargo.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Cargo>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> findByCombo() throws DataAccessException {
		return (List<Cargo>)this.entityManager.createNamedQuery("Cargo.findByCombo").getResultList();
	}

}