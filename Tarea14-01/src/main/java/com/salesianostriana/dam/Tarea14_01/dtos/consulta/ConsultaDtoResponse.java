package com.salesianostriana.dam.Tarea14_01.dtos.consulta;

import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Consulta;

import java.time.LocalDateTime;

public record ConsultaDtoResponse(
        Long id,
        String observaciones,
        String diagnostico,
        LocalDateTime fecha,
        Cita cita
) {

    public static ConsultaDtoResponse of(Consulta consulta){
        return new ConsultaDtoResponse(
                consulta.getId(),
                consulta.getObservaciones(),
                consulta.getDiagnostico(),
                consulta.getFecha(),
                consulta.getCita()
        );
    }
}
