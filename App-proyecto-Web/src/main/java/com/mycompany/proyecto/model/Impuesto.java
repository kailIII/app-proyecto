package com.mycompany.proyecto.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Rodrigo Garcete
 * @since 15/12/2013
 */
@Entity
@Table(name = "impuestos")
@NamedQueries({
	@NamedQuery(name="Impuesto.findById", query="SELECT i FROM Impuesto i WHERE i.codigo = :codigo"),
	@NamedQuery(name="Impuesto.findByName", query="SELECT i FROM Impuesto i WHERE i.nombre LIKE :nombre"),
	@NamedQuery(name="Impuesto.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Impuesto(i.codigo, i.nombre) FROM Impuesto AS i ORDER BY i.codigo"),
	@NamedQuery(name="Impuesto.findByAll", query="SELECT i FROM Impuesto i ORDER BY i.codigo")
})
public class Impuesto extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;
	
	@NotNull
	private BigDecimal porcentaje;
	
	private int activo;
	
	//Constructor por Defecto
	public Impuesto() {
		super();
	}
	
	public Impuesto(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//Metodos Getters and Setters
	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}