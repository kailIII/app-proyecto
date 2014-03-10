package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Formula;
import com.mycompany.proyecto.model.FormulaDetalle;
import com.mycompany.proyecto.repository.FormulaRepository;

/**
 * Implementacion de JPA de la interfaz {@link FormulaRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaFormulaRepositoryImpl implements FormulaRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Formula findById(Long codigo) throws DataAccessException {
        Query query = this.em.createNamedQuery("Formula.findById");
        query.setParameter("codigo", codigo);
        return (Formula)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formula> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createNamedQuery("Formula.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Formula>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Formula> getAll() throws DataAccessException {
		return (List<Formula>)em.createNamedQuery("Formula.findByAll").getResultList();
	}

	@Override
	public void save(Formula c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Formula c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

	@Override
	public void save(Formula f, List<FormulaDetalle> fDetalles)
			throws DataAccessException {
		if (f.getCodigo() == null) {
			this.em.persist(f);
		} else {
			this.em.merge(f);
		}
		
		if (fDetalles != null && fDetalles.size() > 0) {
			for (FormulaDetalle fd : fDetalles) {
				//Le pasamos el Id del pedido del objeto persistente
				fd.getFormula().setCodigo(f.getCodigo());
				//verificamos si la entidad esta administrado
				this.em.persist(em.contains(fd) ? fd : em.merge(fd));
			}
		}
		this.em.flush();
		//limpiamos la lista
		fDetalles.clear();
	}

}