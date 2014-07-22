package com.mycompany.proyecto.dao;

import java.io.Serializable;
import com.mycompany.proyecto.model.Banco;

/**
 * Contrato de Persistencia para la entidad <code>Banco</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface BancoRepository extends Dao<Banco, Serializable> {
	
}