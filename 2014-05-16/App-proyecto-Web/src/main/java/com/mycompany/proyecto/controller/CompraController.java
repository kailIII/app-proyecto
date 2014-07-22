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
import com.mycompany.proyecto.model.Compra;
import com.mycompany.proyecto.model.Proveedor;
import com.mycompany.proyecto.service.CompraService;
import com.mycompany.proyecto.service.ProveedorService;
/**
 * Handles requests for the application home page.
 * Anotando una clase Java como @Controller se convierte en un controlador, 
 * es decir, en una clase encargada de recibir las peticiones HttpServletRequest.
 * 
 * El objeto Model simplemente es un mapa donde guardaremos los objetos 
 * que queremos pasar a la vista (es la M de MVC)
 * 
 * Principal componente do framework <code>Spring MVC</code>, esse é o controller do cadastro de mercadorias. 
 * 
 * <p>Tem como responsabilidade: definir o mapeamento de navegação, acionar validadores e conversores de dados, 
 * fornecer e receber os dados da camada de visão (<code>JSP</code>).</p>
 * 
 * <p>Os métodos de navegação, retornam a url definida no Tiles. Veja também o arquivo <code>views.xml</code>.</p>
 * 
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@RequestMapping(value="/compra")
@Controller
public class CompraController {
	
	private static final Logger log = LoggerFactory.getLogger(CompraController.class);
	
	private CompraService compraService;
	
	@Autowired
	public CompraController(CompraService is){
		this.compraService = is;
	}
	
	@Autowired
	private ProveedorService proveedorService;
	
	/**
	 * Punto de entrada de la aplicação ("/").
	 * @param uiModel recibe la lista de compras
	 * @return url para cargar el listado de compras.
	 */
	@RequestMapping(value="/listado",method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("compras", compraService.getAll());
		log.debug("Consultando en la BD y mostrando todos las Compras");
		return "listaCompras";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de compras
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		Compra c = new Compra();
		uiModel.addAttribute("compra", c);
		cargarComboProveedor(uiModel, c);
		log.debug("Listo para insertar compra");
		return "incluirCompra";
	}
	
	/**
	 * Método ejecutado en la insercion del registro de compra.
	 * @param instancia del objeto compra con los datos cargados recibido de la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String crear(@Valid Compra c, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("compra",c);
            //uiModel.addAttribute("active", "incluir");
            return "incluirCompra";
        }

		this.compraService.save(c);
		log.debug("Compra persistido: "+ c.getCodigo());
		return "redirect:/compra/listado";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion del registro de compras.
	 * @param id de la compra que va a ser editado.
	 * @param uiModel almacena el objeto compra que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Compra c = compraService.findById(id);
		if (c != null) {
			uiModel.addAttribute("compra", c);
			cargarComboProveedor(uiModel, c);
			log.debug("Listo para editar Compra");
		}
		return "editarCompra";
	}
	
	/**
	 * Método ejecutado al actualizar el registro de compras
	 * @param c objeto compra cargado, recibido de la pantalla 
	 * @param bindingResult componente usado para verificar problemas con validacion.
	 * @param uiModel
	 * @return url para el listado, se algun error de validacion fue encontrado, regresa a la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Compra c, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("compra", c);
            return "editarCompra";
        }
		this.compraService.save(c);
		log.debug("Compra actualizado: " + c.getCodigo());
		return "redirect:/compra/listado";
	}
	
	/**
	 * Método ejecutado para la eliminacion del registro de compras
	 * @param id de compra que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Compra m = compraService.findById(id);
		if (m != null) {
			this.compraService.remove(m); 
			log.debug("Compra removido: "+m.getCodigo());
		}
		return "redirect:/compra/listado";
    }
	
	/**
	 * Carga el Componente combo Box en la pantalla con los proveedores existentes
	 * @param uiModel 
	 * @param c objeto Compra
	 */
	private void cargarComboProveedor(Model uiModel, Compra c){
		List<Proveedor> proveedores = proveedorService.findByCombo();
		uiModel.addAttribute("proveedores", proveedores);
	}
	
}