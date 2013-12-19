package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Marca;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.MarcaRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaMarcaRepositoryImpl implements MarcaRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Marca findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Marca b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Marca)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Marca b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Marca>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> getAll() throws DataAccessException {
		return (List<Marca>)em.createQuery("SELECT m FROM Marca m order by m.codigo").getResultList();
	}

	@Override
	public void save(Marca c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
			this.em.flush();
		}else {
			this.em.merge(c);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Marca c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}