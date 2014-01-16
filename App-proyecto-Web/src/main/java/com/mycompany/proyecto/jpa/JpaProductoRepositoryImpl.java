package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Producto;
import com.mycompany.proyecto.repository.ProductoRepository;

/**
 * Implementacion de JPA de la interfaz {@link ProductoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaProductoRepositoryImpl implements ProductoRepository {
	
	@PersistenceContext
	private EntityManager em;

    public Producto findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Producto.findById");
        query.setParameter("codigo", codigo);
        return (Producto) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByName(String nombre, int pag) throws DataAccessException {
        Query query = this.em.createNamedQuery("Producto.findByName");
        query.setParameter("nombre", nombre + "%");
        query.setMaxResults(pag);
        return (List<Producto>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getAll(int pag) throws DataAccessException {
		Query query = this.em.createNamedQuery("Producto.findAll");  
		return (List<Producto>)query.getResultList();
	}

	@Override
	public void save(Producto p) throws DataAccessException {
		if(p.getCodigo() == null){
			this.em.persist(p);
		}else {
			this.em.merge(p);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Producto p) throws DataAccessException {
		this.em.remove(em.contains(p) ? p : em.merge(p));
		return true;
	}

}