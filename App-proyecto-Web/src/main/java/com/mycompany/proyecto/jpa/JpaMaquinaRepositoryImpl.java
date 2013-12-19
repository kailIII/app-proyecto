package com.mycompany.proyecto.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Maquina;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.MaquinaRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaMaquinaRepositoryImpl implements MaquinaRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Maquina findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Maquina b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Maquina)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Maquina> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT b FROM Maquina b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Maquina>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Maquina> getAll() throws DataAccessException {
		return (List<Maquina>)em.createQuery("SELECT b FROM Maquina b order by i.codigo").getResultList();
	}

	@Override
	public void save(Maquina c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Maquina c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}