package com.mycompany.proyecto.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.proyecto.model.Marca;
import com.mycompany.proyecto.service.MarcaService;

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
 * @since 29/12/2013
 */
@RequestMapping(value="/marca")
@Controller
public class MarcaController {

	private MarcaService marcaService;
	
	@Autowired
	public MarcaController(MarcaService is){
		this.marcaService = is;
	}
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(params="list",method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("marcas", marcaService.getAll());
		return "listaMarcas";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(params="form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		uiModel.addAttribute("marca", new Marca());
		return "incluirMarca";
	}
	
	/**
	 * Método ejecutado en la insercion.
	 * @param instancia de unidadMedida con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String crear(@Valid Marca marca, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("marca", marca);
            return "incluirMarca";
        }
		
		this.marcaService.save(marca);
		return "redirect:/marca?list";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion.
	 * @param id de unidadMedida que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Marca m = marcaService.findById(id);
		if (m != null) {
			uiModel.addAttribute("marca", m);
		}
		return "editarMarca";
	}
	
	/**
	 * Método ejecutado al actualizar el registro.
	 * @param marca objeto con los datos enviados de la pantalla.
	 * @param bindingResult componente usado para verificar problemas de validacion
	 * @param uiModel
	 * @return a url para a listado, si algun error de validacion fue encontrado,
	 * regresa a la pagina de edicion
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Marca marca, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("marca", marca);
            return "editarMarca";
        }
		this.marcaService.save(marca);
		return "redirect:/marca?list";
	}
	
	/**
	 * Método ejecutado para la eliminacion.
	 * @param id de unidadMedida que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Marca m = marcaService.findById(id);
		if (m != null) {
			this.marcaService.remove(m); 
		}
		return "redirect:/marca?list";
    }
	
}