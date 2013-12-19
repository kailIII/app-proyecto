package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Insumo;
import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.PedidoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaPedidoRepositoryImpl implements PedidoRepository {
	
	@PersistenceContext
	private EntityManager em;


    @Override
	public Pedido findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Pedido b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Pedido)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM Pedido b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Pedido>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> getAll() throws DataAccessException {
		return (List<Pedido>)em.createQuery("SELECT p FROM Pedido p order by p.codigo").getResultList();
	}

	@Override
	public void save(Pedido c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
			this.em.flush();
		}else {
			this.em.merge(c);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Pedido c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insumo> getInsumos() throws DataAccessException {
		Query query = this.em.createQuery("FROM Insumo");
        //query.setParameter("nombre", nombre + "%");
        //query.setMaxResults(pag);
        return (List<Insumo>)query.getResultList();
	}

}