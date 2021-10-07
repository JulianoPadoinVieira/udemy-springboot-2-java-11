package com.br.tresemeia.courseUdemy.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
		
	}
	
	

}
