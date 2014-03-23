package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Proveedor;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.ProveedorRepository;
/**
 * Implementacion de JPA de la interfaz {@link ProveedorRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaProveedorRepositoryImpl extends BaseDao<Proveedor, Serializable> implements ProveedorRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Proveedor.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Proveedor>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> findByCombo() throws DataAccessException {
		return (List<Proveedor>)entityManager.createNamedQuery("Proveedor.findByCombo").getResultList();
	}

}