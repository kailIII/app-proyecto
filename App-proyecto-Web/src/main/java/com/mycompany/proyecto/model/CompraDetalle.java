package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "compra_detalles")
public class CompraDetalle extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToMany
	@JoinColumn(name = "compra_id")
	private Compra compra;

	@OneToMany
	@JoinColumn(name = "cd_insumo_id")
	private Producto producto;

	@OneToMany
	@JoinColumn(name = "cd_umedida_id")
	private UnidadMedida umedida;

	@Column(name = "insumo_cantidad")
	private BigDecimal insumoCantidad;

	// Constructor por Defecto
	public CompraDetalle() {

	}

	public BigDecimal getInsumoCantidad() {
		return insumoCantidad;
	}

	public void setInsumoCantidad(BigDecimal insumoCantidad) {
		this.insumoCantidad = insumoCantidad;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public UnidadMedida getUmedida() {
		return umedida;
	}

	public void setUmedida(UnidadMedida umedida) {
		this.umedida = umedida;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}