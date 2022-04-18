package com.bernardpaula.clinicamedica.services.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException{
	private static final long serialVersionUID = 1L;

	ObjectNotFoundExceptions(String msg){
		super(msg);
	}
	
	ObjectNotFoundExceptions(String msg, Throwable cause){
		super(msg, cause);
	}
}
