package com.films.api.films_api.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }

}
