package com.mycompany.proyecto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	/**
	 * MappedBy: informamos el nombre de la variable de instancia,
	 * que va a indicar a quien el One pertenece
	 * TargetEntity: informa cual es la asociacion entre las entidades
	 * FetchType.Lazy: Este tipo fue escogido por performance
	 * cascade: ALL para permitir alteraciones en todos los relacionamientos
	 */
	@OneToMany(mappedBy = "pedido", targetEntity = PedidoDetalle.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoDetalle> pDetalles;

	//Constructor por Defecto
	public Pedido() {
		super();
		this.proveedor = new Proveedor();
		this.estado = "";
	}

	//Metodos Getters and Setters
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
	
	public void setpDetalles(List<PedidoDetalle> pDetalles) {
		this.pDetalles = pDetalles;
	}
	
	public List<PedidoDetalle> getpDetalles() {
		return pDetalles;
	}

}