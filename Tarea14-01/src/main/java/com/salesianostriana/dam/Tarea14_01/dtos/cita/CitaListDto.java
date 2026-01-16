package com.salesianostriana.dam.Tarea14_01.dtos.cita;

import com.salesianostriana.dam.Tarea14_01.dtos.consulta.ConsultaDetailDto;
import com.salesianostriana.dam.Tarea14_01.dtos.paciente.PacienteDetailDto;
import com.salesianostriana.dam.Tarea14_01.dtos.profesional.ProfesionalDetailDto;
import com.salesianostriana.dam.Tarea14_01.models.Estado;

public record CitaListDto(
            Long id,
            Estado estado,
            PacienteDetailDto paciente,
            ProfesionalDetailDto profesionalDetailDto,
            ConsultaDetailDto consulta

) {
}
