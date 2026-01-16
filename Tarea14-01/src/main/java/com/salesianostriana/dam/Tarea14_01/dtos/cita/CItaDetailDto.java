package com.salesianostriana.dam.Tarea14_01.dtos.cita;

import com.salesianostriana.dam.Tarea14_01.dtos.consulta.ConsultaDetailDto;
import com.salesianostriana.dam.Tarea14_01.dtos.paciente.PacienteDetailDto;
import com.salesianostriana.dam.Tarea14_01.dtos.profesional.ProfesionalDetailDto;
import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Estado;

public record CItaDetailDto(
        Estado estado,
        ConsultaDetailDto consulta,
        PacienteDetailDto paciente,
        ProfesionalDetailDto profesional
) {
    public static CItaDetailDto of(Cita cita) {
        return new CItaDetailDto(
                cita.getEstado(),
                ConsultaDetailDto.of(cita.getConsulta()),
                PacienteDetailDto.of(cita.getPaciente()),
                ProfesionalDetailDto.of(cita.getProfesional())
        );
    }

}
