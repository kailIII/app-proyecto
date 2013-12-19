package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Impuesto;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.ImpuestoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaImpuestoRepositoryImpl implements ImpuestoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Impuesto findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Impuesto b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Impuesto)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Impuesto> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM Impuesto b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Impuesto>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Impuesto> getAll() throws DataAccessException {
		return (List<Impuesto>)em.createQuery("SELECT i FROM Impuesto i order by i.codigo").getResultList();
	}

	@Override
	public void save(Impuesto c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
			this.em.flush();
		}else {
			this.em.merge(c);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Impuesto c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}