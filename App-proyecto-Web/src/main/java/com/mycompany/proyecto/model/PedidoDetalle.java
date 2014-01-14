package com.mycompany.proyecto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
/**
 * @author Rodrigo Garcete
 * @since 02/12/2013
 */
@Entity
@Table(name = "pedido_detalles")
public class PedidoDetalle extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id") //, insertable= false, updatable=false
	@NotNull
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "pd_insumo_id") //, insertable= false, updatable=false
	@NotNull
	private Producto itemId;
	
	/**
	 * Utilizado en la Vista, para el paso de parametros con la funcion
	 * Ajax de JQuery, especificamente retorna el codigo del insumo
	 */
	@Transient
	private Long id;
	
	/**
	 * Utilizado en la Vista, para pasar el codigo del Pedido mediante
	 * Ajax, devuelve como parametro
	 */
	@Transient
	private Long pedidoId;

	@NotNull
	private BigDecimal cantidad;

	@Column(name = "cantidad_recibido")
	private BigDecimal cantidadRecibido;

	// Constructor por Defecto
	public PedidoDetalle() {
		super();
		this.cantidad = BigDecimal.ZERO;
		this.cantidadRecibido = BigDecimal.ZERO;
		this.id = 0L;
		this.itemId = new Producto();
		this.pedido = new Pedido();
	}
	
	public PedidoDetalle(Producto I, Pedido P){
		super();
		itemId = I;
		pedido = P;
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

	public Producto getProducto() {
		return itemId;
	}

	public void setProducto(Producto itemId) {
		this.itemId = itemId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	
	public Long getPedidoId() {
		return pedidoId;
	}

}