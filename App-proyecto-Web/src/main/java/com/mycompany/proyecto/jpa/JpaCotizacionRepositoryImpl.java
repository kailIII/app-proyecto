package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Cotizacion;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.CotizacionRepository;
/**
 * Implementacion de JPA de la interfaz {@link CotizacionRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaCotizacionRepositoryImpl extends BaseDao<Cotizacion, Serializable> implements CotizacionRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cotizacion> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Cotizacion b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Cotizacion>)query.getResultList();
	}

}