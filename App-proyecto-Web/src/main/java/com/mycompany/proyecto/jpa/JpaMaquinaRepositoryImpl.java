package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Maquina;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.MaquinaRepository;
/**
 * Implementacion de JPA de la interfaz {@link MaquinaRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaMaquinaRepositoryImpl extends BaseDao<Maquina, Serializable> implements MaquinaRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Maquina> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Maquina b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Maquina>)query.getResultList();
	}

}