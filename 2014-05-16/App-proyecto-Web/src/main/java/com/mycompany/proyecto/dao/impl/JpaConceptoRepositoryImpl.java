package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.ConceptoRepository;
import com.mycompany.proyecto.model.Concepto;
/**
 * Implementacion de JPA de la interfaz {@link ConceptoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaConceptoRepositoryImpl extends BaseDao<Concepto, Serializable> implements ConceptoRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Concepto> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Concepto b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Concepto>)query.getResultList();
	}

}