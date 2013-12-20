package com.mycompany.proyecto.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase de Entidad mapeado por la tabla pedidos
 * de la BD
 * @author Rodrigo Garcete
 * @since 20/12/2013
 */
@Entity
@Table(name = "pedidos")
public class Pedido extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String estado;

	//Se tendra en cuenta solo el dia, mes y ano.
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "ped_proveedor_id")
	private Proveedor proveedor;

	public Pedido() {

	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}