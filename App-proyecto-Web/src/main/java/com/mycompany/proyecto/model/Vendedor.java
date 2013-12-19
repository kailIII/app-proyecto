package com.mycompany.proyecto.model;

public class Vendedor extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	public Vendedor() {
		
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}