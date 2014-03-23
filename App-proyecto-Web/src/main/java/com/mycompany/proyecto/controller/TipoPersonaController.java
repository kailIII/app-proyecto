package com.mycompany.proyecto.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mycompany.proyecto.model.TipoPersona;
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
@RequestMapping(value="/tpersona")
@Controller
public class TipoPersonaController {
	
	//private static final Logger log = LoggerFactory.getLogger(DepositoController.class);
	
	public static final int DEFAULT_TIPO_PERSONA_POR_PAGINA = 25;

	private final TipoPersonaService tpService;
	
	@Autowired
	public TipoPersonaController(TipoPersonaService tps){
		this.tpService = tps;
	}

	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(value="/listado", method = RequestMethod.GET) //value="/listado" , params = "lista"
	public String listar(Model uiModel) {
		uiModel.addAttribute("tpersonas", tpService.getAll());
		return "listaTpersonas";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(value="/form", method = RequestMethod.GET) //, params = "form"
	public String crearForm(Model uiModel) {
		uiModel.addAttribute("tpersona", new TipoPersona());
		return "incluirTpersona";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(value="/form", method = RequestMethod.POST) //value="/form", 
	public String crear(@Valid TipoPersona tp, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("tpersona", tp);
            return "incluirTpersona";
        } 
		
		this.tpService.save(tp);
		return "redirect:/tpersona/listado";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) //value = "/edit/{id}", 
	
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		TipoPersona tp = tpService.findById(id);
		if (tp != null) {
			uiModel.addAttribute("tpersona", tp);
		}
		return "editarTpersona";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT) //value = "edit/{id}", 
	public String editar(@Valid TipoPersona tp, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("tpersona", tp);
            return "editarTpersona";
        }
		this.tpService.save(tp);
		return "redirect:/tpersona/listado";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.DELETE) //value = "/edit/{id}", 
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		TipoPersona tp = tpService.findById(id);
		if (tp != null) {
			this.tpService.remove(tp); 
		}
		return "redirect:/tpersona/listado";
    }
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	@ResponseBody
	private TipoPersona getTipoPersona() {
		//TipoPersona t = tpService.findById(codigo); @PathVariable Long codigo
		return new TipoPersona("Respuesta en formato dependiente del header de la peticion");
	}
	
}