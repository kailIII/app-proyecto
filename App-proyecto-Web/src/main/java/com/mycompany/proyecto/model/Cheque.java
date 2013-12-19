package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "cheques")
public class Cheque extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private Long secuencia;
	
	private String serie;
	
	private String chequeNumero;
	
	private Date vencimiento;
	
	private BigDecimal monto;
	
	private String orden;
	
	public Cheque(){
		
	}

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getChequeNumero() {
		return chequeNumero;
	}

	public void setChequeNumero(String chequeNumero) {
		this.chequeNumero = chequeNumero;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}
	
	

}
