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
import com.mycompany.proyecto.model.Departamento;
import com.mycompany.proyecto.model.Pais;
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
 * @since 21-11-2013
 */
@RequestMapping(value="/dep")
@Controller
public class DepartamentoController {
	
	private DepartamentoService depService;
	
	@Autowired
	public DepartamentoController(DepartamentoService is){
		this.depService = is;
	}
	
	@Autowired
	private PaisService paisService;
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(params="list",method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("departamentos", depService.getAll());
		return "listaDepartamentos";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(params="form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		Departamento d = new Departamento();
		uiModel.addAttribute("departamento", d);
		cargarComboPais(uiModel, d);
		return "incluirDepartamento";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String crear(@Valid Departamento d, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("departamento", d);
            return "incluirDepartamento";
        }
		
		this.depService.save(d);
		return "redirect:/dep?list";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Departamento d = depService.findById(id);
		if (d != null) {
			uiModel.addAttribute("departamento", d);
			cargarComboPais(uiModel, d);
		}
		return "editarDepartamento";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Departamento d, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("departamento", d);
            return "editarDepartamento";
        }
		this.depService.save(d);
		return "redirect:/dep?list";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Departamento d = depService.findById(id);
		if (d != null) {
			this.depService.remove(d); 
		}
		return "redirect:/dep?list";
    }
	
	private void cargarComboPais(Model uiModel, Departamento d){
		List<Pais> paises = paisService.findByCombo();
		uiModel.addAttribute("paises", paises);
	}
	
}