package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.RecepcionInsumo;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.RecepcionInsumoRepository;
/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaRecepcionInsumoRepositoryImpl extends BaseDao<RecepcionInsumo, Serializable> implements RecepcionInsumoRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecepcionInsumo> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM RecepcionInsumo b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<RecepcionInsumo>)query.getResultList();
	}

}