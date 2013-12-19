package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Usuario;
import com.mycompany.proyecto.repository.UsuarioRepository;

/**
 * Implementacion de JPA de la interfaz {@link InusmoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaUsuarioRepositoryImpl implements UsuarioRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Usuario findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT i FROM Usuario i WHERE i.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Usuario) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT i FROM Usuario i WHERE i.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Usuario>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAll() throws DataAccessException {
		return (List<Usuario>)em.createQuery("select i from Usuario i order by i.codigo").getResultList();
	}

	@Override
	public void save(Usuario usuario) throws DataAccessException {
    	if (usuario.getCodigo() == null) {
    		this.em.persist(usuario);
		} else {
			this.em.merge(usuario);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Usuario usuario) throws DataAccessException {
		this.em.remove(em.contains(usuario) ? usuario : em.merge(usuario));
		return true;
	}

}