package com.mycompany.proyecto.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
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
	
	public Empleado() {
		
	}

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