package com.salesianostriana.dam.Tarea14_01.dtos.consulta;

import com.salesianostriana.dam.Tarea14_01.models.Consulta;

public record ConsultaDetailDto(
        String observaciones,
        String diagnostico
) {

    public static ConsultaDetailDto of(Consulta consulta){
        return new ConsultaDetailDto(
                consulta.getObservaciones(),
                consulta.getDiagnostico()
        );
    }
}
