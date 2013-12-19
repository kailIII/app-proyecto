package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ciudades")
public class Ciudad extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;

	private int activo;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "ciudad_id")
//	private Proveedor proveedor;

	@ManyToOne //(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="departamento_id")
	@NotNull
	private Departamento departamento;

	@ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="pais_id")
	@NotNull
	private Pais pais;

	// Constructor por Defecto
	public Ciudad() {

	}
	
	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}