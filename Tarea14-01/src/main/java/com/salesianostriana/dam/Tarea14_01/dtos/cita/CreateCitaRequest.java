package com.salesianostriana.dam.Tarea14_01.dtos.cita;

import com.salesianostriana.dam.Tarea14_01.models.Estado;

import java.time.LocalDateTime;

public record CreateCitaRequest(
        LocalDateTime fechaHora,
        Estado estado,
        Long idPaciente,
        Long idProfesional
) {
}
