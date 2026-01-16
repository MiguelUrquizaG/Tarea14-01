package com.salesianostriana.dam.Tarea14_01.dtos.paciente;

import com.salesianostriana.dam.Tarea14_01.models.Paciente;

import java.time.LocalDateTime;

public record PacienteDetailDto(
    String nombre,
    LocalDateTime fechaNacimiento
) {

    public static PacienteDetailDto of (Paciente paciente){
        return new PacienteDetailDto(
                paciente.getNombre(),
                paciente.getFechaNacimiento()
        );
    }
}
