package com.mycompany.proyecto.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.mycompany.proyecto.model.Pais;
import com.mycompany.proyecto.service.PaisService;
/**
 * 
 * @author Rodrigo Garcete
 * @since 07/01/2014
 */
@WebService(serviceName="paisService")
public class PaisServiceEndpoint extends SpringBeanAutowiringSupport {

	@Autowired
	private PaisService paisService;
	
	//Delega la responsabilidad a la capa de servicios
	@WebMethod
	public List<Pais> getPaisAll(){
		return paisService.getAll();
	}
	
	@WebMethod
	public void addPais(Pais p){
		paisService.save(p);
	}
	
	@WebMethod
	public void deletePais(Pais p){
		paisService.remove(p);
	}
	
}
