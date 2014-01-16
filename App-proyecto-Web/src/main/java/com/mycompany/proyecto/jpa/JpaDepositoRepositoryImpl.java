package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Deposito;
import com.mycompany.proyecto.repository.DepositoRepository;
/**
 * Implementacion de JPA de la interfaz {@link DepositoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaDepositoRepositoryImpl implements DepositoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Deposito findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Deposito.findById");
        query.setParameter("codigo", codigo);
        return (Deposito)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deposito> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Deposito.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Deposito>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Deposito> getAll() throws DataAccessException {
		return (List<Deposito>)em.createNamedQuery("Deposito.findByAll").getResultList();
	}

	@Override
	public void save(Deposito c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Deposito c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deposito> findByCombo() throws DataAccessException {
		return (List<Deposito>)em.createNamedQuery("Deposito.findByCombo").getResultList();
	}

}