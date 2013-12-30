package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.UnidadMedida;
import com.mycompany.proyecto.repository.UnidadMedidaRepository;

/**
 * Implementacion de JPA de la interfaz {@link UnidadMedidaRepository}
 * @author Rodrigo Garcete
 * @since 21-11-2013
 */
@Repository
public class JpaUnidadMedidaRepositoryImpl implements UnidadMedidaRepository {
	
	@PersistenceContext
	private EntityManager em;

	public UnidadMedida findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT i FROM UnidadMedida i WHERE i.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (UnidadMedida) query.getSingleResult(); 
	}

	@SuppressWarnings("unchecked")
	public List<UnidadMedida> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT i FROM UnidadMedida i WHERE i.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<UnidadMedida>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UnidadMedida> getAll() throws DataAccessException {
		return (List<UnidadMedida>)em.createQuery("SELECT i FROM UnidadMedida i ORDER BY i.codigo").getResultList();
	}

	@Override
	public void save(UnidadMedida umedida) throws DataAccessException {
		if(umedida.getCodigo() == null){
			this.em.persist(umedida);
		}else {
			this.em.merge(umedida);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(UnidadMedida umedida) throws DataAccessException {
		this.em.remove(em.contains(umedida) ? umedida : em.merge(umedida));
		return true;
	}
	
}