package com.salesianostriana.dam.Tarea14_01.repository;

import com.salesianostriana.dam.Tarea14_01.dtos.CitaPacienteDTO;
import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Paciente;
import com.salesianostriana.dam.Tarea14_01.models.Profesional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional,Long> {

    //@Query("select c from Citas c where c.profesional.id =?1")
    /*
    @Query("select new com.salesianostriana.dam.Tarea14_01.CitaPacienteDTO(c.id,c.fechaHora,c.estado,p.nombre,p.email) " +
            "FROM Cita c JOIN c.paciente p WHERE c.profesional.id = :idProfesional")
    public List<CitaPacienteDTO>prueba(Long idProfesional);*/




}
