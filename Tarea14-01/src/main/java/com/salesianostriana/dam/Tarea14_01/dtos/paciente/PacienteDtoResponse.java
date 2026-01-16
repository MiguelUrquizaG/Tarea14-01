package com.salesianostriana.dam.Tarea14_01.dtos.paciente;

import com.salesianostriana.dam.Tarea14_01.dtos.cita.CitaListDto;
import com.salesianostriana.dam.Tarea14_01.models.Paciente;

import java.time.LocalDateTime;
import java.util.List;

public record PacienteDtoResponse(
        Long id,
        String nombre,
        String email,
        LocalDateTime fechaNacimiento,
        List<CitaListDto> citaDtoResponseList
) {

    /*public static PacienteDtoResponse of (Paciente paciente){
        return new PacienteDtoResponse(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getFechaNacimiento(),
                //paciente.getCitaSet().forEach(cita -> CitaListDto::of);
        )
    }*/

}
