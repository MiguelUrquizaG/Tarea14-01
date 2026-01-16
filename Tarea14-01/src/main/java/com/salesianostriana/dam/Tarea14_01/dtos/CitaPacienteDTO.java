package com.salesianostriana.dam.Tarea14_01.dtos;

import java.time.LocalDateTime;

public record CitaPacienteDTO(
        Long id,
        LocalDateTime fechaHora,
        String estado,
        String nombrePaciente,
        String emailPaciente
) {
}
