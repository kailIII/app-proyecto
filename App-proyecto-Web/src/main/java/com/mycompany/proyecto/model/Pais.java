package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entidad Pais, cada objeto representa un registro de la respectiva tabla
 * @author Rodrigo Garcete 
 * @since 23/11/2013
 */
@Entity
@Table(name = "paises")
@NamedQueries({
	@NamedQuery(name="Pais.findById", query="SELECT p FROM Pais p WHERE p.codigo = :codigo"),
	@NamedQuery(name="Pais.findByName", query="SELECT p FROM Pais p WHERE p.nombre LIKE :nombre"),
	@NamedQuery(name="Pais.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Pais(p.codigo, p.nombre) FROM Pais AS p ORDER BY p.codigo"),
	@NamedQuery(name="Pais.findByAll", query="SELECT p FROM Pais p ORDER BY p.codigo")
})
public class Pais extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;

	private int activo;

	// Constructor por Defecto
	public Pais() {
		super();
	}
	
	public Pais(Long codigo, String nombre){
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

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}