package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Empresa;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.EmpresaRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaEmpresaRepositoryImpl implements EmpresaRepository {
	
	private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public Empresa findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM Empresa c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Empresa)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM Empresa c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Empresa>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> getAll() throws DataAccessException {
		return (List<Empresa>)em.createQuery("SELECT c FROM Empresa c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(Empresa c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Empresa c) throws DataAccessException {
		this.em.remove(c);
		return true;
	}

}