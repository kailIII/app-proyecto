package com.mycompany.proyecto.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.proyecto.model.Formula;
import com.mycompany.proyecto.model.FormulaDetalle;
import com.mycompany.proyecto.service.FormulaService;
import com.mycompany.proyecto.service.ProductoService;
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
@RequestMapping(value="/formula")
@Controller
public class FormulaController {
	
	private ArrayList<FormulaDetalle> listaItems = new ArrayList<FormulaDetalle>();

	private FormulaService formulaService;
	
	@Autowired
	public FormulaController(FormulaService is){
		this.formulaService = is;
	}
	
	@Autowired
	private ProductoService productoService;
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(value="/listado",method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("formulas", formulaService.getAll());
		listaItems.clear();
		return "listaFormulas";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		uiModel.addAttribute("formula", new Formula());
		uiModel.addAttribute("productos", productoService.findByInsumo());
		return "incluirFormula";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String crear(@Valid Formula formula, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("formula", formula);
            //uiModel.addAttribute("active", "incluir");
            return "incluirFormula";
        }
		
		this.formulaService.save(formula);
		return "redirect:/formula/listado";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Formula m = formulaService.findById(id);
		if (m != null) {
			uiModel.addAttribute("formula", m);
		}
		return "editarFormula";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Formula formula, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("formula", formula);
            return "editarFormula";
        }
		this.formulaService.save(formula);
		return "redirect:/formula/listado";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Formula m = formulaService.findById(id);
		if (m != null) {
			this.formulaService.remove(m); 
		}
		return "redirect:/formula/listado";
    }
	
	/**
	 * 
	 * @param item
	 * @param bindingResult
	 */
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public void addItemLista(@ModelAttribute(value = "item") FormulaDetalle item, BindingResult bindingResult){
		if (!bindingResult.hasErrors()) {
			//El id lo pasamos al Id del Insumo
			item.getProducto().setCodigo(item.getId());
			//cargamos el bean a la lista
			System.out.println("paso x aqui add");
			listaItems.add(item); 
		}
	}
	
	@RequestMapping(value = "/quitarItem", method = RequestMethod.POST)
	public void quitarItemLista(@ModelAttribute(value = "item") FormulaDetalle item, BindingResult bindingResult){
		if (!bindingResult.hasErrors()) {
			//El id lo pasamos al Id del Insumo
			//item.getInsumo().setCodigo(item.getId());
			for (int i = 0; i < listaItems.size(); i++) {
				FormulaDetalle fd = listaItems.get(i);
				
				System.out.println("Item Id :" + item.getId());
				System.out.println("Item Cantidad :" + item.getCantidad());
				
				if (fd.getProducto().getCodigo().equals(item.getId()) &&  
						fd.getCantidad().equals(item.getCantidad())) {
						System.out.println("paso para remover");
						listaItems.remove(i); //remuevo de la lista por el indice
					}
			}
			System.out.println("paso x quitar");
		}
	}
	
}