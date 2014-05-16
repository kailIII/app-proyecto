package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.EmpresaRepository;
import com.mycompany.proyecto.model.Empresa;
/**
 * Implementacion de JPA de la interfaz {@link EmpresaRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaEmpresaRepositoryImpl extends BaseDao<Empresa, Serializable> implements EmpresaRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT c FROM Empresa c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Empresa>)query.getResultList();
	}

}