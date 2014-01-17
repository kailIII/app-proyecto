package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Empleado;
import com.mycompany.proyecto.repository.EmpleadoRepository;
/**
 * Implementacion de JPA de la interfaz {@link EmpleadoRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaEmpleadoRepositoryImpl implements EmpleadoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Empleado findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Empleado.findById");
        query.setParameter("codigo", codigo);
        return (Empleado)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Empleado.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Empleado>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> getAll() throws DataAccessException {
		return (List<Empleado>)em.createNamedQuery("Empleado.findByAll").getResultList();
	}

	@Override
	public void save(Empleado c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Empleado c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findByCombo() throws DataAccessException {
		return (List<Empleado>)em.createNamedQuery("Empleado.findByCombo").getResultList();
	}
}