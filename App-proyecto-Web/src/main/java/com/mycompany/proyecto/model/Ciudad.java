package com.mycompany.proyecto.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * Entidad Ciudad que hace referencia a la tabla ciudades en 
 * el modelo de Base de Datos
 * @author Rodrigo Garcete
 * @since 20/12/2013
 * Se ha utilizado JPA Proyection
 */
@Entity
@Table(name = "ciudades")
@NamedQueries({
	@NamedQuery(name="Ciudad.findById", query="SELECT c FROM Ciudad c WHERE c.codigo = :codigo"),
	@NamedQuery(name="Ciudad.findByName", query="SELECT c FROM Ciudad c WHERE c.nombre LIKE :nombre"),
	@NamedQuery(name="Ciudad.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Ciudad(c.codigo, c.nombre) FROM Ciudad AS c ORDER BY c.codigo"),
	@NamedQuery(name="Ciudad.findByAll", query="SELECT c FROM Ciudad c ORDER BY c.codigo")
})
public class Ciudad extends NamedEntity {

	private static final long serialVersionUID = 1L;

	private String abreviatura;

	private int activo;

	@ManyToOne
	@JoinColumn(name="departamento_id")
	@Basic(optional=false)
	private Departamento departamento;

	@ManyToOne 
	@JoinColumn(name="pais_id")
	@Basic(optional=false)
	private Pais pais;

	// Constructor por Defecto
	public Ciudad() {
		super();
		this.departamento = new Departamento();
		this.pais = new Pais();
	}
	
	public Ciudad(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos de Obtencion y establecimientos
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