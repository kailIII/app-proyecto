package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Grupo;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.GrupoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaGrupoRepositoryImpl implements GrupoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Grupo findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT g FROM Grupo g WHERE g.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Grupo)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT g FROM Grupo g WHERE g.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Grupo>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> getAll() throws DataAccessException {
		return (List<Grupo>)em.createQuery("SELECT g FROM Grupo g order by g.codigo").getResultList();
	}

	@Override
	public void save(Grupo g) throws DataAccessException {
		if(g.getCodigo() == null){
			this.em.persist(g);
			this.em.flush();
		}else {
			this.em.merge(g);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Grupo c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}