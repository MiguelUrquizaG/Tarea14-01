package com.salesianostriana.dam.Tarea14_01.errors;

public class CitaNotFoundException extends EntityNotFound {
    public CitaNotFoundException(String message) {
        super(message);
    }

    public CitaNotFoundException(Long id){
        super("No se ha podido encontrar una cita con el id:" +id);
    }

}
