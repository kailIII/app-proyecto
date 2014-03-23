package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Usuario;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.UsuarioRepository;
/**
 * Implementacion de JPA de la interfaz {@link UsuarioRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaUsuarioRepositoryImpl extends BaseDao<Usuario, Serializable> implements UsuarioRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Usuario.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Usuario>)query.getResultList();
	}

}