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
 * Implementacion de JPA de la interfaz {@link InusmoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaProductoRepositoryImpl implements ProductoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Producto findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT p FROM Producto p WHERE p.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Producto) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Producto>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getAll() throws DataAccessException {
		return (List<Producto>)em.createQuery("select p from Producto p order by p.codigo").getResultList();
	}
	
	@Override
	public void save(Producto producto) throws DataAccessException {
		if (producto.getCodigo() == null) {
			this.em.persist(producto);
			this.em.flush();
		} else {
			this.em.merge(producto);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Producto producto) throws DataAccessException {
		this.em.remove(em.contains(producto) ? producto : em.merge(producto));
		return true;
	}

}