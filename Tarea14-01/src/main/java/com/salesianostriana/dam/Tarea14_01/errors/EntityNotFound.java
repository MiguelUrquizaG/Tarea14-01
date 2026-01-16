package com.salesianostriana.dam.Tarea14_01.errors;

public class EntityNotFound extends RuntimeException {
    public EntityNotFound(String message) {
        super(message);
    }
}
