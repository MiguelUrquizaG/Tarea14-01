package com.salesianostriana.dam.Tarea14_01.dtos.cita;

import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Estado;

import java.time.LocalDateTime;

public record CitaDtoCmd(
        LocalDateTime fechaHora,
        Estado estado,
        Long idConsulta,
        Long idPaciente,
        Long idProfesional
) {

}
