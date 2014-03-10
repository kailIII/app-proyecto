package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produccion_detalles")
public class ProduccionDetalle extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "produccion_id") //, insertable= false, updatable=false
	@NotNull
	private Produccion produccion;
	
	@ManyToOne
	@JoinColumn(name = "producto_id") //, insertable= false, updatable=false
	@NotNull
	private Producto producto;
	
	private Double cantidad;
	
	//Constructor por Defecto
	public ProduccionDetalle() {
		
	}

	////Metodos Getters and Setters
	public Produccion getProduccion() {
		return produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
}