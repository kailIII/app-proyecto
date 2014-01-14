package com.mycompany.proyecto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lotes")
public class Lote extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "insumo_id")
	private Producto producto;
	
	@Temporal(TemporalType.DATE)
	private Date vencimiento;

	private int activo;

	public Lote() {

	}
	
	public Producto getInsumo() {
		return producto;
	}

	public void setInsumo(Producto p) {
		this.producto = p;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public Date getVencimiento() {
		return vencimiento;
	}
	
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

}