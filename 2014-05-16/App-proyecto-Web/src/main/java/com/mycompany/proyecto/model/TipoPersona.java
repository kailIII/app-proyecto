package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "tipo_personas")
@NamedQueries({
	@NamedQuery(name="TipoPersona.findById", query="SELECT i FROM TipoPersona i WHERE i.codigo = :codigo AND i.activo=1"),
	@NamedQuery(name="TipoPersona.findByName", query="SELECT i FROM TipoPersona i WHERE i.nombre LIKE :nombre ORDER BY i.nombre"),
	@NamedQuery(name="TipoPersona.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.TipoPersona(i.codigo, i.nombre) "
			+ "FROM TipoPersona AS i WHERE i.activo=1 ORDER BY i.codigo"),
	@NamedQuery(name="TipoPersona.findByAll", query="SELECT NEW com.mycompany.proyecto.model.TipoPersona(i.codigo, i.nombre) "
			+ "FROM TipoPersona AS i WHERE i.activo=1 ORDER BY i.codigo")
})

public class TipoPersona extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	//Constructores por Defecto
	public TipoPersona() {
		super();
	}
	
	public TipoPersona(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//Getters and Setters
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}