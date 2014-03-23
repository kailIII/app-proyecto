package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Departamento;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.DepartamentoRepository;
/**
 * Implementacion de JPA de la interfaz {@link DepartamentoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaDepartamentoRepositoryImpl extends BaseDao<Departamento, Serializable> implements DepartamentoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Departamento.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Departamento>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByCombo() throws DataAccessException {
		return (List<Departamento>)entityManager.createNamedQuery("Departamento.findByCombo").getResultList();
	}

}