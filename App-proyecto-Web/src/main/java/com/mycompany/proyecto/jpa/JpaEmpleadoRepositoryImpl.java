package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Empleado;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.EmpleadoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaEmpleadoRepositoryImpl implements EmpleadoRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Empleado findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM Empleado c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Empleado)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM Empleado c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Empleado>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> getAll() throws DataAccessException {
		return (List<Empleado>)em.createQuery("SELECT c FROM Empleado c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(Empleado c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Empleado c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}