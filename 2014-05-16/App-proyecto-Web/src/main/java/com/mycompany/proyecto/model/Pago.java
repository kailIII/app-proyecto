package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "pagos")
public class Pago extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="fecha_documento")
	private Date fechaDocumento;
	
	@Column(name="fecha_operacion")
	private Date fechaOperacion;
	
	private String tipo;
	
	//private Set<Operacion> operacionTipo;
	
	@Column(name="recibo_numero")
	private String reciboNumero;
	
	//private Set<Cuenta> cuenta;
	
	private BigDecimal cotizacion;
	
	//private Set<Proveedor> proveedor;
	
	@Column(name="monto_total")
	private BigDecimal montoTotal;
	
	private int activo;
	
	private String obs;
	
	//Constructor por defecto
	public Pago() {
		
	}

	//Metodos Getters and Setters
	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

//	public Set<Operacion> getOperacionTipo() {
//		return operacionTipo;
//	}
//
//	public void setOperacionTipo(Set<Operacion> operacionTipo) {
//		this.operacionTipo = operacionTipo;
//	}

	public String getReciboNumero() {
		return reciboNumero;
	}

	public void setReciboNumero(String reciboNumero) {
		this.reciboNumero = reciboNumero;
	}

//	public Set<Cuenta> getCuenta() {
//		return cuenta;
//	}
//
//	public void setCuenta(Set<Cuenta> cuenta) {
//		this.cuenta = cuenta;
//	}

	public BigDecimal getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(BigDecimal cotizacion) {
		this.cotizacion = cotizacion;
	}

//	public Set<Proveedor> getProveedor() {
//		return proveedor;
//	}
//
//	public void setProveedor(Set<Proveedor> proveedor) {
//		this.proveedor = proveedor;
//	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMonto_total(BigDecimal monto_total) {
		this.montoTotal = monto_total;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}