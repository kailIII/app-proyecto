package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Banco;
import com.mycompany.proyecto.repository.BancoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaBancoRepositoryImpl implements BancoRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Banco findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Banco b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Banco)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Banco> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM Banco b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Banco>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Banco> getAll() throws DataAccessException {
		return (List<Banco>)em.createQuery("SELECT b FROM Banco b order by i.codigo").getResultList();
	}

	@Override
	public void save(Banco banco) throws DataAccessException {
		if(banco.getCodigo() == null){
			this.em.persist(banco);
		}else {
			this.em.merge(banco);
		}
	}

	@Override
	public Boolean remove(Banco banco) throws DataAccessException {
		this.em.remove(banco);
		return true;
	}

}