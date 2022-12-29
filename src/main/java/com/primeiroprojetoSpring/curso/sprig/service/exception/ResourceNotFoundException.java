package com.primeiroprojetoSpring.curso.sprig.service.exception;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUIID =1L;
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id );
    }
}
