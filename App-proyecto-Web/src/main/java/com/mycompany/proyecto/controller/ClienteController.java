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
import com.mycompany.proyecto.model.Cliente;
import com.mycompany.proyecto.model.TipoPersona;
import com.mycompany.proyecto.service.CiudadService;
import com.mycompany.proyecto.service.ClienteService;
import com.mycompany.proyecto.service.TipoPersonaService;
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
@RequestMapping("/cliente")
@Controller
public class ClienteController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService is){
		this.clienteService = is;
	}
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private TipoPersonaService tpService;
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(method = RequestMethod.GET, params ="list")
	public String listar(Model uiModel) {
		uiModel.addAttribute("clientes", clienteService.getAll());
		log.debug("Consultando en la BD y mostrando todos los clientes");
		return "listaClientes";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(method = RequestMethod.GET, params ="/form")
	public String crearForm(Model uiModel) {
		Cliente c = new Cliente();
		uiModel.addAttribute("cliente", new Cliente());
		cargarComboTP(uiModel, c);
		cargarComboCiudad(uiModel, c);
		log.debug("Listo para insertar cliente");
		return "incluirCliente";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String crear(@Valid Cliente c, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("cliente", c);
            return "incluirInsumo";
        }
		
		this.clienteService.save(c);
		log.debug("Cliente persistido: "+ c.getCodigo());
		return "redirect:/cliente?list";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Cliente c = clienteService.findById(id);
		if (c != null) {
			uiModel.addAttribute("cliente", c);
			cargarComboTP(uiModel, c);
			cargarComboCiudad(uiModel, c);
			log.debug("Listo para editar Cliente");
		}
		return "editarCliente";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Cliente c, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("cliente", c);
            return "editarCliente";
        }
		this.clienteService.save(c);
		log.debug("Cliente actualizado: " + c.getCodigo());
		return "redirect:/cliente?list";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Cliente m = clienteService.findById(id);
		if (m != null) {
			this.clienteService.remove(m); 
			log.debug("Cliente removido: "+m.getCodigo());
		}
		return "redirect:/cliente?list";
    }
	
	private void cargarComboCiudad(Model uiModel, Cliente c){
		List<Ciudad> ciudades = ciudadService.findByCombo();
		uiModel.addAttribute("ciudades", ciudades);
	}
	
	private void cargarComboTP(Model uiModel, Cliente c){
		List<TipoPersona> tpersonas = tpService.findByCombo();
		uiModel.addAttribute("tpersonas", tpersonas);
	}
	
}