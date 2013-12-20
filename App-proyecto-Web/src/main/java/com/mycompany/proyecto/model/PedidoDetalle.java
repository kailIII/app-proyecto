package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author Rodrigo Garcete
 * @since 02/12/2013
 */
@Entity
@Table(name = "pedido_detalles")
public class PedidoDetalle extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id", insertable = false, updatable = false)
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "pd_insumo_id", insertable = false, updatable = false)
	private Insumo insumo;

	@ManyToOne
	@JoinColumn(name = "pd_umedida_id", insertable = false, updatable = false)
	private UnidadMedida umedida;

	private BigDecimal cantidad;

	@Column(name = "cantidad_recibido")
	private BigDecimal cantidadRecibido;

	// Constructor por Defecto
	public PedidoDetalle() {

	}

	//Metodos de Obtencion y establicimiento
	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCantidadRecibido() {
		return cantidadRecibido;
	}

	public void setCantidadRecibido(BigDecimal cantidadRecibido) {
		this.cantidadRecibido = cantidadRecibido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public UnidadMedida getUmedida() {
		return umedida;
	}

	public void setUmedida(UnidadMedida umedida) {
		this.umedida = umedida;
	}

}