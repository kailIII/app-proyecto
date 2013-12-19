package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.TipoPersona;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.TipoPersonaRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaTipoPersonaRepositoryImpl implements TipoPersonaRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public TipoPersona findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM TipoPersona b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (TipoPersona)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPersona> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM TipoPersona b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<TipoPersona>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPersona> getAll() throws DataAccessException {
		return (List<TipoPersona>)em.createQuery("SELECT b FROM TipoPersona b order by i.codigo").getResultList();
	}

	@Override
	public void save(TipoPersona c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(TipoPersona c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}