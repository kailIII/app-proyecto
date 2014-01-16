package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Departamento;
import com.mycompany.proyecto.repository.DepartamentoRepository;
/**
 * Implementacion de JPA de la interfaz {@link DepartamentoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaDepartamentoRepositoryImpl implements DepartamentoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Departamento findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Departamento.findById");
        query.setParameter("codigo", codigo);
        return (Departamento)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Departamento.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Departamento>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> getAll() throws DataAccessException {
		return (List<Departamento>)em.createNamedQuery("Departamento.findByAll").getResultList();
	}

	@Override
	public void save(Departamento c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Departamento c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByCombo() throws DataAccessException {
		return (List<Departamento>)em.createNamedQuery("Departamento.findByCombo").getResultList();
	}

}