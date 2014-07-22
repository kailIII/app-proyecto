package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.PagoRepository;
import com.mycompany.proyecto.model.Pago;
/**
 * Implementacion de JPA de la interfaz {@link PagoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaPagoRepositoryImpl extends BaseDao<Pago, Serializable> implements PagoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Pago b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Pago>)query.getResultList();
	}
	
}