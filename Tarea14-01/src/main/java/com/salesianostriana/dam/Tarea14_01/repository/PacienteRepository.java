package com.salesianostriana.dam.Tarea14_01.repository;

import com.salesianostriana.dam.Tarea14_01.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
