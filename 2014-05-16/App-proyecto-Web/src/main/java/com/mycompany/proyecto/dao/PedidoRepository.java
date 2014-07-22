package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.model.PedidoDetalle;
/**
 * Contrato de Persistencia para la entidad <code>Pedido</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface PedidoRepository extends Dao<Pedido, Serializable>{
	
	List<PedidoDetalle> findPedidoDetalles(Long codigo) throws DataAccessException;
	
	List<Pedido> findByName(String nombre) throws DataAccessException; 
	
	void savePedido(Pedido pedido, List<PedidoDetalle> pDetalle ) throws DataAccessException;
	
}