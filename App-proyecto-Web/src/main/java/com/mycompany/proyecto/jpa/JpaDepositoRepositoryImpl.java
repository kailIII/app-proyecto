package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Deposito;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.DepositoRepository;
/**
 * Implementacion de JPA de la interfaz {@link DepositoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaDepositoRepositoryImpl extends BaseDao<Deposito, Serializable> implements DepositoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Deposito> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Deposito.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Deposito>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Deposito> findByCombo() throws DataAccessException {
		return (List<Deposito>)entityManager.createNamedQuery("Deposito.findByCombo").getResultList();
	}

}