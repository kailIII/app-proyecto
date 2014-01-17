package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
@NamedQueries({
	@NamedQuery(name = "Cargo.findAll", query = "SELECT NEW com.mycompany.proyecto.model.Cargo(p.codigo, p.nombre) FROM Cargo AS p ORDER BY p.codigo"),
	@NamedQuery(name = "Cargo.findById", query = "select p from Cargo p where p.codigo = :codigo"),
	@NamedQuery(name = "Cargo.findByName", query ="select p from Cargo p where p.nombre LIKE :nombre"),
	@NamedQuery(name = "Cargo.findByCombo", query = "SELECT NEW com.mycompany.proyecto.model.Cargo(p.codigo, p.nombre) FROM Cargo AS p ORDER BY p.codigo")
})
public class Cargo extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	
	private int activo;
	
	//Constructores por Defecto
	public Cargo(){
		super();
	}
	
	public Cargo(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//Metodos Getters and Setters
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public int getActivo() {
		return activo;
	}
	
}