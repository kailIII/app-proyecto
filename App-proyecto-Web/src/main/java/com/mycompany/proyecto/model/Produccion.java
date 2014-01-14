package com.mycompany.proyecto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producciones")
public class Produccion extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "fechaEmision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@Column(name = "fechaProduccion")
	@Temporal(TemporalType.DATE)
	private Date fechaProduccion;
	
	@Column(name = "emitido_por")
	private int emitidoPor;
	
	@Column(name = "confirmado_por")
	private int confirmadoPor;
	
	private String obs;
	
	private int estado;

	//Constructor por Defecto
	public Produccion() {
		super();
	}

	//Metodos de Obtencion y Establecimiento
	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaProduccion() {
		return fechaProduccion;
	}

	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	public int getEmitidoPor() {
		return emitidoPor;
	}

	public void setEmitidoPor(int emitidoPor) {
		this.emitidoPor = emitidoPor;
	}

	public int getConfirmadoPor() {
		return confirmadoPor;
	}

	public void setConfirmadoPor(int confirmadoPor) {
		this.confirmadoPor = confirmadoPor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}