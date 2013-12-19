package com.mycompany.proyecto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "producciones")
public class Produccion extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	
	@Column(name = "producto_id")
	private int producto;

	public Produccion() {
		
	}
	
	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

}