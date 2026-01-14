package com.salesianostriana.dam.Tarea14_01.services;

import com.salesianostriana.dam.Tarea14_01.models.Paciente;
import com.salesianostriana.dam.Tarea14_01.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Paciente getById(Long id){
        return pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado paciente con ese Id"));
    }

}
