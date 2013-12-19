package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Departamento;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.DepartamentoRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaDepartamentoRepositoryImpl implements DepartamentoRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Departamento findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT c FROM Departamento c WHERE c.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Departamento)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT c FROM Departamento c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Departamento>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> getAll() throws DataAccessException {
		return (List<Departamento>)em.createQuery("SELECT c FROM Departamento c ORDER BY c.codigo").getResultList();
	}

	@Override
	public void save(Departamento c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
	}

	@Override
	public Boolean remove(Departamento c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}