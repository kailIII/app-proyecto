package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Producto;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.ProductoRepository;
/**
 * Implementacion de JPA de la interfaz {@link ProductoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaProductoRepositoryImpl extends BaseDao<Producto, Serializable> implements ProductoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByName(String nombre, int pag) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Producto.findByName");
        query.setParameter("nombre", nombre + "%");
        query.setMaxResults(pag);
        return (List<Producto>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByCombo() throws DataAccessException {
		return this.entityManager.createNamedQuery("Producto.findByCombo").getResultList();  
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByInsumo() throws DataAccessException {
		return this.entityManager.createNamedQuery("Producto.findByInsumo").getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll() { 
		return this.entityManager.createNamedQuery("Producto.findByAll").getResultList();
	}

}