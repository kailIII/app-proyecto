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
	@NamedQuery(name="Empleado.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Empleado"
			+ "(p.codigo, p.nombre) FROM Empleado AS p ORDER BY p.codigo"),
	@NamedQuery(name="Empleado.findByAll", query="SELECT NEW com.mycompany.proyecto.model.Empleado"
			+ "(p.codigo, p.nombre, p.apellido, p.celular) FROM Empleado AS p ORDER BY p.codigo")
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
	
	private String email;
	
	private int sexo;
	
	@Column(name = "hora_extra")
	private Double horaExtra;
	
	@Column(name = "tiene_credito")
	private int tieneCredito;
	
	private Double sueldo;
	
	@Column(name = "nro_asegurado_ips")
	private String nroAseguradoIPS;
	
	@Column(name = "cant_hijos")
	private int cantHijos;
	
	@Column(name = "descuento_ips")
	private int descuentoIPS;
	
	@Column(name="limite_credito")
	private Double limiteCredito;
	
	private String obs;
	
	//Constructores por Defecto
	public Empleado() {
		super();
	}
	
	public Empleado(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public Empleado(Long codigo, String nombre, String apellido, String celular){
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
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

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public Double getHoraExtra() {
		return horaExtra;
	}

	public void setHoraExtra(Double horaExtra) {
		this.horaExtra = horaExtra;
	}

	public int getTieneCredito() {
		return tieneCredito;
	}

	public void setTieneCredito(int tieneCredito) {
		this.tieneCredito = tieneCredito;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public String getNroAseguradoIPS() {
		return nroAseguradoIPS;
	}

	public void setNroAseguradoIPS(String nroAseguradoIPS) {
		this.nroAseguradoIPS = nroAseguradoIPS;
	}

	public int getCantHijos() {
		return cantHijos;
	}

	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}

	public int getDescuentoIPS() {
		return descuentoIPS;
	}

	public void setDescuentoIPS(int descuentoIPS) {
		this.descuentoIPS = descuentoIPS;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
}