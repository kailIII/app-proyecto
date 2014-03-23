package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Impuesto;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.ImpuestoRepository;
/**
 * Implementacion de JPA de la interfaz {@link ImpuestoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaImpuestoRepositoryImpl extends BaseDao<Impuesto, Serializable> implements ImpuestoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Impuesto> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Impuesto.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Impuesto>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Impuesto> findByCombo() throws DataAccessException {
		return (List<Impuesto>)entityManager.createNamedQuery("Impuesto.findByCombo").getResultList();
	}

}