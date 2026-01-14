package com.salesianostriana.dam.Tarea14_01.services;

import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Estado;
import com.salesianostriana.dam.Tarea14_01.models.Profesional;
import com.salesianostriana.dam.Tarea14_01.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;


    public Cita crearCita(LocalDateTime fechHora, Estado estado,Long idPaciente,Long idProfesional, Long idConsulta){
        //Profesional profesional =
        return null;
    }


}
