package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Formula;
import com.mycompany.proyecto.model.FormulaDetalle;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.FormulaRepository;
/**
 * Implementacion de JPA de la interfaz {@link FormulaRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaFormulaRepositoryImpl  extends BaseDao<Formula, Serializable> implements FormulaRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Formula> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Formula.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Formula>)query.getResultList();
	}
	
	@Override
	public void save(Formula f, List<FormulaDetalle> fDetalles)
			throws DataAccessException {
		if (f.getCodigo() == null) {
			this.entityManager.persist(f);
		} else {
			this.entityManager.merge(f);
		}
		
		if (fDetalles != null && fDetalles.size() > 0) {
			for (FormulaDetalle fd : fDetalles) {
				//Le pasamos el Id del pedido del objeto persistente
				fd.getFormula().setCodigo(f.getCodigo());
				//verificamos si la entidad esta administrado
				this.entityManager.persist(entityManager.contains(fd) ? fd : entityManager.merge(fd));
			}
		}
		this.entityManager.flush();
		//limpiamos la lista
		fDetalles.clear();
	}

}