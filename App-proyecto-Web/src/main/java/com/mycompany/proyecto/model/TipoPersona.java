package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tipo_personas")
@NamedQueries({
	@NamedQuery(name="TipoPersona.findById", query="SELECT i FROM TipoPersona i WHERE i.codigo = :codigo"),
	@NamedQuery(name="TipoPersona.findByName", query="SELECT i FROM TipoPersona i WHERE i.nombre LIKE :nombre"),
	@NamedQuery(name="TipoPersona.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.TipoPersona(i.codigo, i.nombre) FROM TipoPersona AS i ORDER BY i.codigo"),
	@NamedQuery(name="TipoPersona.findByAll", query="SELECT i FROM TipoPersona i ORDER BY i.codigo")
})

public class TipoPersona extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private int activo;
	
	@XmlElement
	private String name;
	
	//Constructores por Defecto
	public TipoPersona() {
		super();
	}
	
	public TipoPersona(String name){
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
	//public void setName(String name){
		//this.name = name;
	//}
}