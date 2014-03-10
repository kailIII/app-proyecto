package com.mycompany.proyecto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produccion")
@NamedQueries({
	@NamedQuery(name="Produccion.findById", query="SELECT c FROM Produccion c WHERE c.codigo = :codigo"),
	@NamedQuery(name="Produccion.findByEstado", query="SELECT c FROM Produccion c WHERE c.estado LIKE :estado"),
	@NamedQuery(name="Produccion.findByCombo", query="SELECT NEW com.mycompany.proyecto.model.Produccion(c.codigo, c.estado) FROM Produccion AS c ORDER BY c.codigo"),
	@NamedQuery(name="Produccion.findByAll", query="SELECT c FROM Produccion c ORDER BY c.codigo")
})
public class Produccion extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "fechaEmision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@Column(name = "fechaProduccion")
	@Temporal(TemporalType.DATE)
	private Date fechaProduccion;
	
	@Column(name = "emitido_por")
	private int emitidoPor;
	
	@Column(name = "confirmado_por")
	private int confirmadoPor;
	
	/**
	 * MappedBy: informamos el nombre de la variable de instancia,
	 * que va a indicar a quien el One pertenece
	 * TargetEntity: informa cual es la asociacion entre las entidades
	 * FetchType.Lazy: Este tipo fue escogido por performance
	 * cascade: ALL para permitir alteraciones en todos los relacionamientos
	 */
	@OneToMany(mappedBy = "produccion", targetEntity = ProduccionDetalle.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProduccionDetalle> pDetalles;
	
	private String obs;
	
	private String estado;

	//Constructores por Defecto
	public Produccion() {
		super();
		
	}
	
	public Produccion(Long codigo, String estado){
		this.codigo = codigo;
		this.estado = estado;
	}

	//Metodos de Obtencion y Establecimiento
	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaProduccion() {
		return fechaProduccion;
	}

	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	public int getEmitidoPor() {
		return emitidoPor;
	}

	public void setEmitidoPor(int emitidoPor) {
		this.emitidoPor = emitidoPor;
	}

	public int getConfirmadoPor() {
		return confirmadoPor;
	}

	public void setConfirmadoPor(int confirmadoPor) {
		this.confirmadoPor = confirmadoPor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<ProduccionDetalle> getpDetalles() {
		return pDetalles;
	}
	
	public void setpDetalles(List<ProduccionDetalle> pDetalles) {
		this.pDetalles = pDetalles;
	}
	
}