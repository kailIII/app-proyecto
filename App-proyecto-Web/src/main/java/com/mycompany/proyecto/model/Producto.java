package com.mycompany.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author rodrigo garcete 
 * Fecha Creacion:21-11-2013
 * 
 * Validaciones con Bean Validations, mecanismo de validaciones de Java
 * basado en anotaciones
 */
@Entity
@Table(name = "productos")
public class Producto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 5, max = 200)
	private String nombre;

	private String descripcion;

	@ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "umedida_id")
	@NotNull
	private UnidadMedida umedida;
	
	@ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "impuesto_id")
	@NotNull
	private Impuesto impuesto;
	
	@ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "marca_id")
	@NotNull
	private Marca marca;
	
	@ManyToOne //(cascade = CascadeType.ALL) //fetch = FetchType.LAZY,
	@JoinColumn(name = "clasificacion_id")
	@NotNull
	private Clasificacion clasificacion;
	
	@ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "grupo_id")
	@NotNull
	private Grupo grupo;
	
	@ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "proveedor_id")
	@NotNull
	private Proveedor proveedor;

//	@OneToMany(orphanRemoval = true)
//	@JoinColumn(name = "insumo_id")
//	@NotNull
//	private List<InsumoStock> insumoStock;
//
//	@OneToMany(mappedBy = "insumo")
//	private List<InsumoPrecio> insumoPrecio; 

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "pd_insumo_id")
//	@NotNull
//	private PedidoDetalle pDetalle;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "cd_insumo_id")
//	@NotNull
//	private CompraDetalle cDetalle;

	private int activo;

	public Producto() {

	}
	
	public UnidadMedida getUmedida() {
		return umedida;
	}

	public void setUmedida(UnidadMedida umedida) {
		this.umedida = umedida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Impuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}