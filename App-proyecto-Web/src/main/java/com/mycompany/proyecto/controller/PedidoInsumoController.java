package com.mycompany.proyecto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.service.PedidoInsumoService;


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
 * @author YaW Tecnologia
 */
@RequestMapping(value="/pedido") 
@Controller
public class PedidoInsumoController {
	
	//private static final Logger log = LoggerFactory.getLogger(PedidoInsumoController.class);
	
	private final PedidoInsumoService pedidoInsumoService;
	
	@Autowired
	public PedidoInsumoController(PedidoInsumoService is){
		this.pedidoInsumoService = is;
	}
	 
	/** Configura um conversor para double em pt-BR, usado no campo de preço.
	* @param binder
	*/
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(Double.class, 
//				new CustomNumberEditor(Double.class, NumberFormat.getInstance(new Locale("es","ES")), true));
//	}
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(value="/listado",method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("pedido", pedidoInsumoService.getAll());
		//log.debug("Consultando en la BD y mostrando todos los pedidos insumos");
		return "listaPedidoInsumos";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		uiModel.addAttribute("pedido", new Pedido());
		
		//Cargamos el listado de insumos
		uiModel.addAttribute("insumos", pedidoInsumoService.getInsumos());
		//log.debug("Listo para insertar pedido insumo");
		return "incluirPedidoInsumo";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String crear(@Valid Pedido pedidoInsumo, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("pedido", pedidoInsumo);
            //uiModel.addAttribute("active", "incluir");
            return "incluirPedidoInsumo";
        }
		pedidoInsumoService.save(pedidoInsumo);
		//log.debug("Pedido Insumo persistido: "+ pedidoInsumo.getCodigo());
		return "redirect:/pedido/listado";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Pedido m = pedidoInsumoService.findById(id);
		if (m != null) {
			uiModel.addAttribute("pedido", m);
			//log.debug("Listo para editar Pedido Insumo");
		}
		return "editarPedidoInsumo";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Pedido pedidoInsumo, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("pedido", pedidoInsumo);
            return "editarPedidoInsumo";
        }
		pedidoInsumoService.save(pedidoInsumo);
		//log.debug("Insumo actualizado: " + pedidoInsumo.getCodigo());
		return "redirect:/pedido/listado";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Pedido m = pedidoInsumoService.findById(id);
		if (m != null) {
			pedidoInsumoService.remove(m); 
			//log.debug("Pedido Insumo removido: "+m.getCodigo());
		}
		return "redirect:/pedido/listado";
    }
	
}