package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Insumo;
import com.mycompany.proyecto.repository.InsumoRepository;

/**
 * Implementacion de JPA de la interfaz {@link InsumoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaInsumoRepositoryImpl implements InsumoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Insumo findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT i FROM Insumo i WHERE i.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Insumo) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insumo> findByName(String nombre, int pag) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT i FROM Insumo i WHERE i.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        query.setMaxResults(pag);
        return (List<Insumo>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Insumo> getAll(int pag) throws DataAccessException {
		Query query = this.em.createQuery("FROM Insumo");  
		return (List<Insumo>)query.getResultList();
	}

	@Override
	public void save(Insumo insumo) throws DataAccessException {
		if(insumo.getCodigo() == null){
			this.em.persist(insumo);
			this.em.flush();
		}else {
			this.em.merge(insumo);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Insumo insumo) throws DataAccessException {
		this.em.remove(em.contains(insumo) ? insumo : em.merge(insumo));
		return true;
	}

}