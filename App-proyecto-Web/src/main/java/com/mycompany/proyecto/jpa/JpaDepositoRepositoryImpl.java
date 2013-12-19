package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Deposito;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.DepositoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaDepositoRepositoryImpl implements DepositoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Deposito findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM Deposito c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Deposito)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deposito> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM Deposito c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Deposito>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Deposito> getAll() throws DataAccessException {
		return (List<Deposito>)em.createQuery("SELECT c FROM Deposito c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(Deposito c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
			this.em.flush();
		}else {
			this.em.merge(c);
			this.em.flush();
		}
	}

	@Override
	public Boolean remove(Deposito c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}