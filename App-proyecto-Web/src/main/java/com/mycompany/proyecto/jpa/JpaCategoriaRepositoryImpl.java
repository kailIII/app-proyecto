package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Categoria;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.CategoriaRepository;
/**
 * Implementacion de JPA de la interfaz {@link CategoriaRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaCategoriaRepositoryImpl extends BaseDao<Categoria, Serializable> implements CategoriaRepository {
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createQuery("SELECT b FROM Categoria b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Categoria>)query.getResultList();
	}

}