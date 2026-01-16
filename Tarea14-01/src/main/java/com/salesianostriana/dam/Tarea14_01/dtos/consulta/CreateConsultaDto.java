package com.salesianostriana.dam.Tarea14_01.dtos.consulta;

import java.time.LocalDateTime;

public record CreateConsultaDto(
        String observaciones,
        String diagnostico,
        LocalDateTime fecha
) {
}
