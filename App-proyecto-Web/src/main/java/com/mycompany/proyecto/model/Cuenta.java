package com.mycompany.proyecto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cuentas")
public class Cuenta extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private boolean esBanco;
	
	@Transient
	private Set<Banco> banco;
	
	private String tipo;
	
	@Transient
	private Set<Moneda> moneda;
	
	private BigDecimal saldo;
	
	private Date fecha;
	
	public Cuenta(){
		
	}

	public boolean isEsBanco() {
		return esBanco;
	}

	public void setEsBanco(boolean esBanco) {
		this.esBanco = esBanco;
	}

	public Set<Banco> getBanco() {
		return banco;
	}

	public void setBanco(Set<Banco> banco) {
		this.banco = banco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Moneda> getMoneda() {
		return moneda;
	}

	public void setMoneda(Set<Moneda> moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}