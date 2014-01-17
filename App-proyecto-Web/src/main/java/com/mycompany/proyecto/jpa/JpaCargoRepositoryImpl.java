package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Cargo;
import com.mycompany.proyecto.repository.CargoRepository;
/**
 * Implementacion de JPA de la interfaz {@link CargoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaCargoRepositoryImpl implements CargoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Cargo findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Cargo.findById");
        query.setParameter("codigo", codigo);
        return (Cargo)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Cargo.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Cargo>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> getAll() throws DataAccessException {
		return (List<Cargo>)em.createNamedQuery("Cargo.findAll").getResultList();
	}

	@Override
	public void save(Cargo cargo) throws DataAccessException {
		if(cargo.getCodigo() == null){
			this.em.persist(cargo);
		}else {
			this.em.merge(cargo);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Cargo cargo) throws DataAccessException {
		this.em.remove(em.contains(cargo) ? cargo : em.merge(cargo));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> findByCombo() throws DataAccessException {
		return (List<Cargo>)em.createNamedQuery("Cargo.findByCombo").getResultList();
	}

}