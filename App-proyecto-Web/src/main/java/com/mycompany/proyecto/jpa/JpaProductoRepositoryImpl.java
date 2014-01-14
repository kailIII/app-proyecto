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
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaProductoRepositoryImpl implements ProductoRepository {
	
	@PersistenceContext
	private EntityManager em;

    public Producto findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT i FROM Producto i WHERE i.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Producto) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByName(String nombre, int pag) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT i FROM Producto i WHERE i.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        query.setMaxResults(pag);
        return (List<Producto>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getAll(int pag) throws DataAccessException {
		Query query = this.em.createQuery("FROM Producto");  
		return (List<Producto>)query.getResultList();
	}

	@Override
	public void save(Producto insumo) throws DataAccessException {
		if(insumo.getCodigo() == null){
			this.em.persist(insumo);
		}else {
			this.em.merge(insumo);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Producto insumo) throws DataAccessException {
		this.em.remove(em.contains(insumo) ? insumo : em.merge(insumo));
		return true;
	}

}