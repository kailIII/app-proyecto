package com.mycompany.proyecto.dao;

import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Venta;
import com.mycompany.proyecto.model.VentaDetalle;
/**
 * Contrato de Persistencia para la entidad <code>Venta</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:22-01-2014
 */
public interface VentaRepository extends Dao<Venta, Serializable>{
	
	void save(Venta v, ArrayList<VentaDetalle> items) throws DataAccessException;
		
}
