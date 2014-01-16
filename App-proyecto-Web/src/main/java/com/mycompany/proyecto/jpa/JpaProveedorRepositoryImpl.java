package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Proveedor;
import com.mycompany.proyecto.repository.ProveedorRepository;

/**
 * Implementacion de JPA de la interfaz {@link ProveedorRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaProveedorRepositoryImpl implements ProveedorRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Proveedor findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Proveedor.findById");
        query.setParameter("codigo", codigo);
        return (Proveedor) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Proveedor.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Proveedor>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> getAll() throws DataAccessException {
		return (List<Proveedor>)em.createNamedQuery("Proveedor.findByAll").getResultList();
	}

	@Override
	public void save(Proveedor proveedor) throws DataAccessException {
    	if (proveedor.getCodigo() == null) {
    		this.em.persist(proveedor);
		} else {
			this.em.merge(proveedor); 	
		}
    	this.em.flush();
	}

	@Override
	public Boolean remove(Proveedor proveedor) throws DataAccessException {
		this.em.remove(em.contains(proveedor) ? proveedor : em.merge(proveedor));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> findByCombo() throws DataAccessException {
		return (List<Proveedor>)em.createNamedQuery("Proveedor.findByCombo").getResultList();
	}

}