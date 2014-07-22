package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="vendedores")
public class Vendedor extends NamedEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Transient
	private int activo;
	
	//Constructor por Defecto
	public Vendedor() {
		
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}