package com.mycompany.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.proyecto.model.Grupo;
import com.mycompany.proyecto.model.Impuesto;
import com.mycompany.proyecto.model.Marca;
import com.mycompany.proyecto.model.Producto;
import com.mycompany.proyecto.model.Proveedor;
import com.mycompany.proyecto.model.UnidadMedida;
import com.mycompany.proyecto.service.GrupoService;
import com.mycompany.proyecto.service.ImpuestoService;
import com.mycompany.proyecto.service.MarcaService;
import com.mycompany.proyecto.service.ProductoService;
import com.mycompany.proyecto.service.ProveedorService;
import com.mycompany.proyecto.service.UnidadMedidaService;


/**
 * Handles requests for the application home page.
 * Anotando una clase Java como @Controller se convierte en un controlador, 
 * es decir, en una clase encargada de recibir las peticiones HttpServletRequest.
 * 
 * El objeto Model simplemente es un mapa donde guardaremos los objetos 
 * que queremos pasar a la vista (es la M de MVC)
 * 
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */

/**
 * Principal componente do framework <code>Spring MVC</code>, esse é o controller do cadastro de mercadorias. 
 * 
 * <p>Tem como responsabilidade: definir o mapeamento de navegação, acionar validadores e conversores de dados, 
 * fornecer e receber os dados da camada de visão (<code>JSP</code>).</p>
 * 
 * <p>Os métodos de navegação, retornam a url definida no Tiles. Veja também o arquivo <code>views.xml</code>.</p>
 * 
 * @author Rodrigo Garcete
 */
@RequestMapping(value="/producto")
@Controller
public class ProductoController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	public static final int DEFAULT_INSUMOS_POR_PAGINA = 25;

	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService is){
		this.productoService = is;
	}
	
	//probando
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private ImpuestoService impuestoService;
	
	@Autowired
	private UnidadMedidaService umedidaService;
	
	@Autowired
	private ProveedorService proveedorService; 
	
	private Map<Integer,String> tipos;
	
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(value="/listado",method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("productos", productoService.getAll());
		log.debug("Consultando en la BD y mostrando todos los insumos");
		return "listaProductos";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		Producto p = new Producto();
		uiModel.addAttribute("producto", p);
		cargarComboUMedida(uiModel, p);
		cargarComboGrupo(uiModel, p);
		cargarComboMarca(uiModel, p);
		cargarComboImpuesto(uiModel, p);
		cargarComboProveedor(uiModel, p);
		cargarTipos(uiModel);
		return "incluirProducto";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String crear(@Valid Producto insumo, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("producto", insumo);
            //uiModel.addAttribute("active", "incluir");
            return "incluirProducto";
        }
		
		this.productoService.save(insumo);
		//log.debug("Producto persistido: "+ insumo.getCodigo());
		return "redirect:/producto/listado";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Producto p = productoService.findById(id);
		
		if (p!= null) {
			uiModel.addAttribute("producto", p);
			cargarComboUMedida(uiModel, p);
			cargarComboGrupo(uiModel, p);
			cargarComboMarca(uiModel, p);
			cargarComboImpuesto(uiModel, p);
			cargarComboProveedor(uiModel, p);
			cargarTipos(uiModel);
			
			log.debug("Listo para editar Producto");
		}
		return "editarProducto";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Producto insumo, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("producto", insumo);
            return "editarProducto";
        }
		this.productoService.save(insumo);
		log.debug("Producto actualizado: " + insumo.getCodigo());
		return "redirect:/producto/listado";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Producto m = productoService.findById(id);
		if (m != null) {
			this.productoService.remove(m); 
			//log.debug("Producto removido: "+m.getCodigo());
		}
		return "redirect:/producto/listado";
    }
	
	private void cargarComboMarca(Model uiModel, Producto p){
		List<Marca> marcas = marcaService.findByCombo();
		uiModel.addAttribute("marcas", marcas);
	}
	
	private void cargarComboGrupo(Model uiModel, Producto p){
		List<Grupo> grupos = grupoService.findByCombo();
		uiModel.addAttribute("grupos", grupos);
	}
	
	private void cargarComboImpuesto(Model uiModel, Producto p){
		List<Impuesto> impuestos = impuestoService.findByCombo();
		uiModel.addAttribute("impuestos", impuestos);
	}
	
	private void cargarComboUMedida(Model uiModel, Producto p){
		List<UnidadMedida> umedidas = umedidaService.findByCombo();
		uiModel.addAttribute("umedidas", umedidas);
	}
	
	private void cargarComboProveedor(Model uiModel, Producto p){
		List<Proveedor> proveedores = proveedorService.findByCombo();
		uiModel.addAttribute("proveedores", proveedores);
	}
	
	private void cargarTipos(Model uiModel){
		tipos = new HashMap<Integer,String>();

		tipos.put(1, "Producto");
		tipos.put(2, "Insumo");
		tipos.put(3, "Paquete");
		tipos.put(4, "Servicio");
		uiModel.addAttribute("tipos", tipos);
	}
	
}