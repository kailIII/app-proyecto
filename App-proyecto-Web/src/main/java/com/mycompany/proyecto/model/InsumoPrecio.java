package com.mycompany.proyecto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name = "insumo_precios")
public class InsumoPrecio extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToMany
	@JoinColumn(name = "insumo_id")
	@NotNull
	private Insumo insumo;
	
	@NotNull @Min(value = 1)
	private BigDecimal precio;
	
	@Column(name = "precio_minimo")
	private BigDecimal precioMinimo;

	@Column(name = "precio_maximo")
	private BigDecimal precioMaximo;
	
	private int activo;
	
	//Constructor por Defecto
	public InsumoPrecio() {
		
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(BigDecimal precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public BigDecimal getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(BigDecimal precioMaximo) {
		this.precioMaximo = precioMaximo;
	}
	
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public int getActivo() {
		return activo;
	}
	
}
