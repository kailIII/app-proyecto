package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.model.PedidoDetalle;
import com.mycompany.proyecto.model.Producto;

/**
 * Contrato de Persistencia para la entidad <code>Pedido</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * Fecha Creacion:21-11-2013
 */
public interface PedidoRepository {

	Pedido findById(Long codigo) throws DataAccessException;
	
	List<PedidoDetalle> findPedidoDetalles(Long codigo) throws DataAccessException;
	
	List<Pedido> findByName(String nombre) throws DataAccessException; 

	List<Pedido> getAll() throws DataAccessException;
	
	List<Producto> getInsumos() throws DataAccessException;
		
	void save(Pedido pedidoInsumo) throws DataAccessException;
	
	void savePedido(Pedido pedido, List<PedidoDetalle> pDetalle ) throws DataAccessException;
		
	Boolean remove(Pedido pedidoInsumo) throws DataAccessException;
	
}