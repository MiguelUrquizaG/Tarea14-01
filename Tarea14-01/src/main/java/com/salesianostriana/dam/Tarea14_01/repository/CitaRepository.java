package com.salesianostriana.dam.Tarea14_01.repository;

import com.salesianostriana.dam.Tarea14_01.models.Cita;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Long> {

    List<Cita> findCitaByProfesional_Id(Long id);

    List<Cita> findCitaByPaciente_Id(Long id);


    @Override
    boolean existsById(Long aLong);
}
