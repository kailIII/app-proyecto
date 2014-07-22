package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.model.PedidoDetalle;
/**
 * Contrato de Servicio para la entidad <code>Pedido</code>
 *  
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
public interface PedidoInsumoService {

	Pedido findById(Long codigo) throws DataAccessException;
	
	List<PedidoDetalle> findPedidoDetalles(Long codigo) throws DataAccessException;
	
	List<Pedido> findByName(String nombre) throws DataAccessException; 

	List<Pedido> getAll() throws DataAccessException;
		
	void save(Pedido pedidoInsumo) throws DataAccessException;
	
	void savePedido(Pedido p, List<PedidoDetalle> listaItems) throws DataAccessException;
		
	Boolean remove(Pedido pedidoInsumo) throws DataAccessException;
	
}