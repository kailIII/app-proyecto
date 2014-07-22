package com.mycompany.proyecto.controller;

import java.util.List;

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

import com.mycompany.proyecto.model.Ciudad;
import com.mycompany.proyecto.model.Proveedor;
import com.mycompany.proyecto.service.CiudadService;
import com.mycompany.proyecto.service.ProveedorService;

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
@RequestMapping(value="/proveedor")
@Controller 
public class ProveedorController {
	
	private static final Logger log = LoggerFactory.getLogger(ProveedorController.class);
	
	private ProveedorService proveedorService;
	
	@Autowired
	public ProveedorController(ProveedorService ps){
		this.proveedorService = ps;
	}
	
	@Autowired
	private CiudadService ciudadService;
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(params="list", method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("proveedores", proveedorService.getAll());
		return "listaProveedores";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		Proveedor p = new Proveedor();
		uiModel.addAttribute("proveedor", p);
		cargarComboCiudad(uiModel, p);
		log.debug("Listo para insertar proveedor");
		return "incluirProveedor";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String crear(@Valid Proveedor proveedor, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("proveedor", proveedor);
            return "incluirProveedor";
        }
		this.proveedorService.save(proveedor);
		return "redirect:/proveedor?list";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Proveedor p = proveedorService.findById(id);
		if (p != null) {
			uiModel.addAttribute("proveedor", p);
			cargarComboCiudad(uiModel, p);
		}
		return "editarProveedor";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Proveedor proveedor, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("proveedor", proveedor);
            return "editarProveedor";
        }
		proveedorService.save(proveedor);
		return "redirect:/proveedor?list";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Proveedor p = proveedorService.findById(id);
		if (p != null) {
			this.proveedorService.remove(p); 
		}
		return "redirect:/proveedor?list";
    }
	
	private void cargarComboCiudad(Model uiModel, Proveedor p){
		List<Ciudad> ciudades = ciudadService.findByCombo();
		uiModel.addAttribute("ciudades", ciudades);
	}
	
}