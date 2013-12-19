package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Entity
@Table(name = "productos")
public class Producto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String descripcion;
	
	private Double cantidad;
	
	private Double precio;
	
	
	public Producto() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}