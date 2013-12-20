package com.mycompany.proyecto.config;

/**
 * Clase que va a permitir encapsular posible excepciones que 
 * pudieran ocurrir en tiempo de ejecucion
 * @author Rodrigo Garcete
 * @since 19/12/2013
 *
 */
public class AppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AppRuntimeException() {
		super();
	}
	
	public AppRuntimeException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}
	
	public AppRuntimeException(String mensaje){
		super(mensaje);
	}
	
	public AppRuntimeException(Throwable causa) {
		super(causa);
	}
	
}
