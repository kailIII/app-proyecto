package com.mycompany.proyecto.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.PedidoDetalle;
/**
 * Contrato de Persistencia para la entidad <code>Pedido Detalle</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author Rodrigo Garcete
 * Fecha Creacion:21-11-2013
 */
public interface PedidoDetalleRepository {

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws DataAccessException
	 */
	PedidoDetalle findById(Long codigo) throws DataAccessException;
		
	/**
	 * Realiza la insercion o actualizacion de insumo en la base de datos
	 * @param cargo
	 * @return el id del objeto persistido
	 * @throws DataAccessException
	 */
	void save(List<PedidoDetalle> pdetalle) throws DataAccessException;
		
	/**
	 * 
	 * @param cargo
	 * @return
	 * @throws DataAccessException
	 */
	Boolean remove(PedidoDetalle pDetalle) throws DataAccessException;
	
}