package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Presupuesto;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.PresupuestoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * 
 * @author rodrigo garcete Fecha Creacion:21-11-2013
 */
@Repository
public class PresupuestoRepositoryImpl implements PresupuestoRepository {

	private EntityManager em = null;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public Presupuesto findById(Long codigo) throws DataAccessException {
		Query query = this.em
				.createQuery("SELECT b FROM Presupuesto b WHERE b.codigo =:codigo");
		query.setParameter("codigo", codigo);
		return (Presupuesto) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Presupuesto> findByName(String nombre)
			throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and
		// pets
		// using 'left join fetch' because it might happen that an owner does
		// not have pets yet
		Query query = this.em
				.createQuery("SELECT b FROM Presupuesto b WHERE b.nombre LIKE :nombre");
		query.setParameter("nombre", nombre + "%");
		return (List<Presupuesto>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Presupuesto> getAll() throws DataAccessException {
		return (List<Presupuesto>) em.createQuery(
				"SELECT b FROM Presupuesto b order by i.codigo")
				.getResultList();
	}

	@Override
	public void save(Presupuesto p) throws DataAccessException {
		if (p.getCodigo() == null) {
			this.em.persist(p);
		} else {
			this.em.merge(p);
		}
	}

	@Override
	public Boolean remove(Presupuesto p) throws DataAccessException {
		this.em.remove(p);
		return true;
	}

}