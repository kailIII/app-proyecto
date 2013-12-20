package com.mycompany.proyecto.config;

/**
 * El proposito de esta clase es encapsular las excepciones, que 
 * pudieran ocurrir en tiempo de compilacion
 * @author Rodrigo Garcete
 * @since 19/12/2013
 */
public class AppException extends Exception {	

	private static final long serialVersionUID = 1L;

	public AppException() {
		super();
	}
	
	public AppException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}
	
	public AppException(String mensaje){
		super(mensaje);
	}
	
	public AppException(Throwable causa){
		super(causa);
	}
}
