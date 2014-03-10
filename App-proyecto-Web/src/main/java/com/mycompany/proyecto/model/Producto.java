package com.mycompany.proyecto.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author rodrigo garcete 
 * Fecha Creacion:21-11-2013
 * 
 * Validaciones con Bean Validations, mecanismo de validaciones de Java
 * basado en anotaciones, las consultas son optimizadas con JPA Projections
 */
@Entity
@Table(name = "productos") //modificar el buscador por Id
@NamedQueries({
	@NamedQuery(name = "Producto.findAll", query = "SELECT NEW com.mycompany.proyecto.model.Producto(p.codigo, p.nombre) "
			+ "FROM Producto AS p ORDER BY p.codigo"),
	@NamedQuery(name = "Producto.findById", query = "select p from Producto p where p.codigo = :codigo"),
	@NamedQuery(name = "Producto.findByName", query ="select p from Producto p where p.nombre LIKE :nombre"),
	@NamedQuery(name = "Producto.findByInsumo", query ="SELECT NEW com.mycompany.proyecto.model.Producto(p.codigo, p.nombre) "
			+ "FROM Producto AS p WHERE p.tipo=2 ORDER BY p.codigo"),
	@NamedQuery(name = "Producto.findByCombo", query = "SELECT NEW com.mycompany.proyecto.model.Producto(p.codigo, p.nombre) "
			+ "FROM Producto AS p ORDER BY p.codigo")
})
public class Producto extends NamedEntity {

	private static final long serialVersionUID = 1L;
	
	private int tipo;

	private String descripcion;

	@OneToOne //targetEntity = UnidadMedida.class, cascade = CascadeType.ALL
	@JoinColumn(name = "umedida_id")
	//@NotNull
	@Basic(optional=false) //columnas pueden definir una constricción de tipo non null, 
	private UnidadMedida umedida; //la cual impide que se inserte un valor null; por tanto, con @Basic(optional=false) nos ajustaríamos a la citada constricción
	
	@OneToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "impuesto_id")
	//@NotNull
	@Basic(optional=false)
	private Impuesto impuesto;
	
	@OneToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "marca_id")
	//@NotNull
	@Basic(optional=false)
	private Marca marca;
	
	@OneToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "grupo_id")
	//@NotNull
	@Basic(optional=false)
	private Grupo grupo;
	
	@OneToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "proveedor_id")
	//@NotNull
	@Basic(optional=false)
	private Proveedor proveedor;

	private int activo;
	
	@Column(name="codigo_barra")
	private String codigoBarra;
	
	private Double pcu;
	
	private Double pcp;
	
	@Temporal(TemporalType.DATE)
	private Date ultimaCompra;

	//Constructor por Defecto
	public Producto() {
		super();
		this.grupo = new Grupo();
		this.impuesto = new Impuesto();
		this.marca = new Marca();
		this.proveedor = new Proveedor();
		this.umedida = new UnidadMedida();
	}
	
	public Producto(Long codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Metodos Getters and Setters
	public UnidadMedida getUmedida() {
		return umedida;
	}

	public void setUmedida(UnidadMedida umedida) {
		this.umedida = umedida;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Double getPcu() {
		return pcu;
	}

	public void setPcu(Double pcu) {
		this.pcu = pcu;
	}

	public Double getPcp() {
		return pcp;
	}

	public void setPcp(Double pcp) {
		this.pcp = pcp;
	}

	public Date getUltimaCompra() {
		return ultimaCompra;
	}

	public void setUltimaCompra(Date ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}
	
}