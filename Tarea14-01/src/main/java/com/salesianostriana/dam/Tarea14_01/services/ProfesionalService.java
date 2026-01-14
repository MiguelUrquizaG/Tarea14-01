package com.salesianostriana.dam.Tarea14_01.services;

import com.salesianostriana.dam.Tarea14_01.models.Profesional;
import com.salesianostriana.dam.Tarea14_01.repository.ProfesionalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesionalService {

    private final ProfesionalRepository profesionalRepository;

    public Profesional getById(Long id){
        return profesionalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado un profesional con ese ID."));
    }
}
