package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.PedidoDetalle;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.PedidoDetalleRepository;
/**
 * Implementacion de JPA de la interfaz {@link PedidoDetalleRepository}
 * @author Rodrigo Garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaPedidoDetalleRepositoryImpl extends BaseDao<PedidoDetalle, Serializable> implements PedidoDetalleRepository {


}