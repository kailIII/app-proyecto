package com.mycompany.proyecto.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Compra;
import com.mycompany.proyecto.model.CompraDetalle;
/**
 * Contrato de Persistencia para la entidad <code>Compra</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface CompraRepository extends Dao<Compra, Serializable> {
	
	List<Compra> findByName(String nombre) throws DataAccessException; 
	
	void save(Compra compra, ArrayList<CompraDetalle> items) throws DataAccessException;
			
}