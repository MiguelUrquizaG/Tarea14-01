package com.salesianostriana.dam.Tarea14_01.repository;

import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Estado;
import com.salesianostriana.dam.Tarea14_01.models.Paciente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {

    @EntityGraph(attributePaths = {"paciente","profesional"})
    Page<Cita>findAll(Pageable pageable);

    List<Cita> findCitaByProfesional_Id(Long id);

    @EntityGraph(attributePaths = {"paciente"})
    List<Cita> findCitaByPaciente_Id(Long id);

    @EntityGraph(attributePaths = {"paciente","profesional"})
    List<Cita> findCitaByEstado(Estado estado);

    @EntityGraph(attributePaths = {"paciente","profesional"})
    List<Cita> findCitaByFechaHoraBetween(LocalDateTime fecha1, LocalDateTime fecha2);

    @Query("select c from Cita c JOIN c.paciente p WHERE c.profesional.id = :idProfesional AND CAST(c.fechaHora AS date) = :fecha ")
    Map<Cita, Paciente> getPrueba(Long idProfesional, LocalDate fecha);

    @Override
    boolean existsById(Long aLong);
}
