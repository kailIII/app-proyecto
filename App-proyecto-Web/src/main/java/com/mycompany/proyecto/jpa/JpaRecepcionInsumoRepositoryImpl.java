package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.RecepcionInsumo;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.RecepcionInsumoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaRecepcionInsumoRepositoryImpl implements RecepcionInsumoRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public RecepcionInsumo findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM RecepcionInsumo b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (RecepcionInsumo)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecepcionInsumo> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM RecepcionInsumo b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<RecepcionInsumo>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecepcionInsumo> getAll() throws DataAccessException {
		return (List<RecepcionInsumo>)em.createQuery("SELECT r FROM RecepcionInsumo r order by r.codigo").getResultList();
	}

	@Override
	public void save(RecepcionInsumo c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(RecepcionInsumo c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}