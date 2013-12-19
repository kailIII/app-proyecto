package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Insumo;
import com.mycompany.proyecto.model.Pedido;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface PedidoInsumoService {

	Pedido findById(Long codigo) throws DataAccessException;
	
	List<Pedido> findByName(String nombre) throws DataAccessException; 

	List<Pedido> getAll() throws DataAccessException;
	
	List<Insumo> getInsumos() throws DataAccessException;
		
	void save(Pedido pedidoInsumo) throws DataAccessException;
		
	Boolean remove(Pedido pedidoInsumo) throws DataAccessException;
	
}