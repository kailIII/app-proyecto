package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Compra;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.CompraRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaCompraRepositoryImpl implements CompraRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Compra findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Compra b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Compra)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Compra b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Compra>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> getAll() throws DataAccessException {
		return (List<Compra>)em.createQuery("SELECT b FROM Compra b order by b.codigo").getResultList();
	}

	@Override
	public void save(Compra c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Compra c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}