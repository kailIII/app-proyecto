package com.mycompany.proyecto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entidad Empleado, cada objeto representa un registo
 * de la tabla correspondiente
 * @author Rodrigo Garcete
 * @since 27/12/2013
 */
@Entity
@Table(name = "empleados")
@NamedQueries({
	@NamedQuery(name="Empleado.findById", query="SELECT p FROM Empleado p WHERE p.codigo = :codigo"),
	@NamedQuery(name="Empleado.findByName", query="SELECT p FROM Empleado p WHERE p.nombre LIKE :nombre"),
	@NamedQuery(name="Empleado.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Empleado(p.codigo, p.nombre) FROM Empleado AS p ORDER BY p.codigo"),
	@NamedQuery(name="Empleado.findByAll", query="SELECT p FROM Empleado p ORDER BY p.codigo")
})
public class Empleado extends Persona {
		
	private static final long serialVersionUID = 1L;

	private String ci;
	
	private String celular;
	
	private String telefono;
	
	@Column(name= "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
//	private Set<Ciudad> ciudad;
//	
//	private Set<EstadoCivil> estadoCivil;
	
	private String email;
	
	private String obs;
	
	//Constructores por Defecto
	public Empleado() {
		super();
	}
	
	public Empleado(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//Metodos Getters and Setters
	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

//	public Set<Ciudad> getCiudad() {
//		return ciudad;
//	}
//
//	public void setCiudad(Set<Ciudad> ciudad) {
//		this.ciudad = ciudad;
//	}
//
//	public Set<EstadoCivil> getEstadoCivil() {
//		return estadoCivil;
//	}
//
//	public void setEstadoCivil(Set<EstadoCivil> estadoCivil) {
//		this.estadoCivil = estadoCivil;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}