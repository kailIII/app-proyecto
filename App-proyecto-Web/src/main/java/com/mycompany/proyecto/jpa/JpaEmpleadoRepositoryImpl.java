package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Empleado;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.EmpleadoRepository;
/**
 * Implementacion de JPA de la interfaz {@link EmpleadoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaEmpleadoRepositoryImpl extends BaseDao<Empleado, Serializable> implements EmpleadoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Empleado.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Empleado>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findByCombo() throws DataAccessException {
		return (List<Empleado>)entityManager.createNamedQuery("Empleado.findByCombo").getResultList();
	}
}