package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table (name = "cotizaciones")
public class Cotizacion extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Set<Moneda> moneda;
	
	private BigDecimal compra;
	
	private BigDecimal venta;
	
	private Date fecha;
	
	public Cotizacion() {
		
	}

	public Set<Moneda> getMoneda() {
		return moneda;
	}

	public void setMoneda(Set<Moneda> moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getCompra() {
		return compra;
	}

	public void setCompra(BigDecimal compra) {
		this.compra = compra;
	}

	public BigDecimal getVenta() {
		return venta;
	}

	public void setVenta(BigDecimal venta) {
		this.venta = venta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
}