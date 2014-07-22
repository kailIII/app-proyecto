package com.mycompany.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monedas")
public class Moneda extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String simbolo;
	
	@Column(name="esbase")
	private boolean esBase;
	
	private Integer decimales;
	
	public Moneda() {
		
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public boolean isEsBase() {
		return esBase;
	}

	public void setEsBase(boolean esBase) {
		this.esBase = esBase;
	}

	public Integer getDecimales() {
		return decimales;
	}

	public void setDecimales(Integer decimales) {
		this.decimales = decimales;
	}
	
}