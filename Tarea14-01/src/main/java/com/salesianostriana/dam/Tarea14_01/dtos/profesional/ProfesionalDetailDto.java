package com.salesianostriana.dam.Tarea14_01.dtos.profesional;

import com.salesianostriana.dam.Tarea14_01.models.Profesional;

public record ProfesionalDetailDto(
        String nombre,
        String especialidad
) {

    public static ProfesionalDetailDto of (Profesional profesional){
        return new ProfesionalDetailDto(
                profesional.getNombre(),
                profesional.getEspecialidad()
        );
    }
}
