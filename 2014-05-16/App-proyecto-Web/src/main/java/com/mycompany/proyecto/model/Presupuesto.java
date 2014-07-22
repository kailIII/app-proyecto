package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "presupuestos")
public class Presupuesto extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	public Presupuesto() {
		
	}
	
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public int getActivo() {
		return activo;
	}
	
}
