package com.mycompany.proyecto.model;

/**
 * Un Simple POJO
 * @author rodrigo garcete
 * @since 21/118/212
 */
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bancos")
public class Banco extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	private String representante;
	
	private String direccion;
	
	private String barrio;
	
	private String telefono;
	
	private String telefono2;
	
	private String celular;
	
	private String celular2;
	
	private String fax;
	
	private String email;
	
	@Transient
	private int activo;
	
	//Constructor por Defecto
	public Banco(){
		
	}
	
	//Metodos Getters and Setters
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	
	public String getRepresentante() {
		return representante;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getActivo() {
		return activo;
	}
	
	public void setActivo(int activo) {
		this.activo = activo;
	}

}