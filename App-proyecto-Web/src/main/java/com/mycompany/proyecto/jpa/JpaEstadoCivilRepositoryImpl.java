package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.EstadoCivil;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.EstadoCivilRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaEstadoCivilRepositoryImpl implements EstadoCivilRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public EstadoCivil findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM EstadoCivil c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (EstadoCivil)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoCivil> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM EstadoCivil c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<EstadoCivil>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoCivil> getAll() throws DataAccessException {
		return (List<EstadoCivil>)em.createQuery("SELECT c FROM EstadoCivil c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(EstadoCivil c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(EstadoCivil c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}