package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Clasificacion;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.ClasificacionRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaClasificacionRepositoryImpl implements ClasificacionRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Clasificacion findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Clasificacion b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Clasificacion)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clasificacion> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Clasificacion b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Clasificacion>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Clasificacion> getAll() throws DataAccessException {
		return (List<Clasificacion>)em.createQuery("SELECT c FROM Clasificacion c order by c.codigo").getResultList();
	}

	@Override
	public void save(Clasificacion c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
			this.em.flush();
		}else {
			this.em.merge(c);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Clasificacion c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}