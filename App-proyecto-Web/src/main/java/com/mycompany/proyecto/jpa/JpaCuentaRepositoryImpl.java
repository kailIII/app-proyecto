package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Cuenta;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.CuentaRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaCuentaRepositoryImpl implements CuentaRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Cuenta findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM Cuenta c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Cuenta)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM Cuenta c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Cuenta>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> getAll() throws DataAccessException {
		return (List<Cuenta>)em.createQuery("SELECT c FROM Cuenta c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(Cuenta c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Cuenta c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}