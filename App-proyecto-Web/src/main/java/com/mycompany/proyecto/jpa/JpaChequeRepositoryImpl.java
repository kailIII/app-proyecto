package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Cheque;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.ChequeRepository;

/**
 * Implementacion de JPA de la interfaz {@link ChequeRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaChequeRepositoryImpl extends BaseDao<Cheque, Serializable> implements ChequeRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cheque> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Cheque b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Cheque>)query.getResultList();
	}

}