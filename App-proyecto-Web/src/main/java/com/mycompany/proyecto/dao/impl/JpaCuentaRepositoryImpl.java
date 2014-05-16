package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.BancoRepository;
import com.mycompany.proyecto.dao.CuentaRepository;
import com.mycompany.proyecto.model.Cuenta;
/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaCuentaRepositoryImpl extends BaseDao<Cuenta, Serializable> implements CuentaRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT c FROM Cuenta c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Cuenta>)query.getResultList();
	}

}