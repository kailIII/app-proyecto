package com.mycompany.proyecto.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.proyecto.model.Ciudad;
import com.mycompany.proyecto.model.Departamento;
import com.mycompany.proyecto.model.Pais;
import com.mycompany.proyecto.service.CiudadService;
import com.mycompany.proyecto.service.DepartamentoService;
import com.mycompany.proyecto.service.PaisService;
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
@RequestMapping(value="/ciudad")
@Controller
public class CiudadController {

	private CiudadService ciudadService;
	
	@Autowired
	public CiudadController(CiudadService is){
		this.ciudadService = is;
	}
	
	@Autowired
	private DepartamentoService depService;
	
	@Autowired
	private PaisService paisService;
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(params="list", method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("ciudades", ciudadService.getAll());
		return "listaCiudades";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(params="form", method = RequestMethod.GET) 
	public String crearForm(Model uiModel) {
		Ciudad c = new Ciudad();
		uiModel.addAttribute("ciudad", c);
		cargarComboDepartamento(uiModel, c);
		cargarComboPais(uiModel, c);
		return "incluirCiudad";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String crear(@Valid Ciudad ciudad, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("ciudad", ciudad);
            return "incluirCiudad";
        }
		this.ciudadService.save(ciudad);
		return "redirect:/ciudad?list";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Ciudad c = ciudadService.findById(id);
		if (c != null) {
			uiModel.addAttribute("ciudad", c);
			cargarComboDepartamento(uiModel, c);
			cargarComboPais(uiModel, c);
		}
		return "editarCiudad";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Ciudad ciudad, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("ciudad", ciudad);
            return "editarCiudad";
        }
		this.ciudadService.save(ciudad);
		return "redirect:/ciudad?list";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Ciudad m = ciudadService.findById(id);
		if (m != null) {
			this.ciudadService.remove(m); 
		}
		return "redirect:/ciudad?list";
    }
	
	private void cargarComboDepartamento(Model uiModel, Ciudad c){
		List<Departamento> departamentos = depService.findByCombo();
		uiModel.addAttribute("departamentos", departamentos);
	}

	private void cargarComboPais(Model uiModel, Ciudad c){
		List<Pais> paises = paisService.findByCombo();
		uiModel.addAttribute("paises", paises);
	}
	
}