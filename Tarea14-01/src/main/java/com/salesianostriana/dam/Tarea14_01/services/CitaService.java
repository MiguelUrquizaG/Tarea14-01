package com.salesianostriana.dam.Tarea14_01.services;

import com.salesianostriana.dam.Tarea14_01.dtos.cita.CitaDtoCmd;
import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Estado;
import com.salesianostriana.dam.Tarea14_01.models.Paciente;
import com.salesianostriana.dam.Tarea14_01.models.Profesional;
import com.salesianostriana.dam.Tarea14_01.repository.CitaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final ProfesionalService profesionalService;
    private final PacienteService pacienteService;


    public Cita getById(Long id){
        return citaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la cita."));
    }

    public Cita crearCita(CitaDtoCmd dto){
        Profesional profesional = profesionalService.getById(dto.idProfesional());
        List<Cita> citaList = citaRepository.findCitaByProfesional_Id(dto.idProfesional());
        List<Cita> pacienteCitaList = citaRepository.findCitaByPaciente_Id(dto.idPaciente());
        Paciente paciente = pacienteService.getById(dto.idPaciente());
        long diferenciaHora = ChronoUnit.HOURS.between(citaList.getLast().getFechaHora() , LocalDateTime.now());
        long diferenciaDia = ChronoUnit.DAYS.between(pacienteCitaList.getLast().getFechaHora(),LocalDateTime.now());

        if(diferenciaHora<1)
            throw new RuntimeException("No se puede poner una cita en la misma hora");

        if (diferenciaDia<1){
            throw new RuntimeException("Un paciente no puede tener dos citas el mismo dia.");
        }

        if(dto.fechaHora().isBefore(LocalDateTime.now())){
            throw new RuntimeException("No se pueden crear citas con fechas pasadas");
        }

        return citaRepository.save(Cita.builder()
                .profesional(profesional)
                .fechaHora(dto.fechaHora())
                .estado(dto.estado())
                .paciente(paciente)
                .build());
    }

    public void cancelarCita(Long id){
        Cita c = citaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado una cita con ese id."));
        if(c.getEstado()!=Estado.ATENDIDA){
            c.setEstado(Estado.CANCELADA);
        }
    }


}
