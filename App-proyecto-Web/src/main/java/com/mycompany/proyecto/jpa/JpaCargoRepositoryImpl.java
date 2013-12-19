package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Cargo;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.CargoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaCargoRepositoryImpl implements CargoRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Cargo findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM Cargo c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Cargo)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM Cargo c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Cargo>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> getAll() throws DataAccessException {
		return (List<Cargo>)em.createQuery("SELECT c FROM Cargo c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(Cargo cargo) throws DataAccessException {
		if(cargo.getCodigo() == null){
			this.em.persist(cargo);
		}else {
			this.em.merge(cargo);
		}
	}

	@Override
	public Boolean remove(Cargo cargo) throws DataAccessException {
		this.em.remove(cargo);
		return true;
	}

}