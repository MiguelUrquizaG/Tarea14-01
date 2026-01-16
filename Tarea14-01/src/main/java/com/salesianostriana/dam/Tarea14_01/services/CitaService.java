package com.salesianostriana.dam.Tarea14_01.services;

import com.salesianostriana.dam.Tarea14_01.dtos.cita.CItaDetailDto;
import com.salesianostriana.dam.Tarea14_01.dtos.cita.CreateCitaRequest;
import com.salesianostriana.dam.Tarea14_01.dtos.consulta.CreateConsultaDto;
import com.salesianostriana.dam.Tarea14_01.errors.CitaNotFoundException;
import com.salesianostriana.dam.Tarea14_01.models.*;
import com.salesianostriana.dam.Tarea14_01.repository.CitaRepository;
import com.salesianostriana.dam.Tarea14_01.repository.ConsultaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final ProfesionalService profesionalService;
    private final PacienteService pacienteService;
    private final ConsultaRepository consultaRepository;


    public Cita getById(Long id){
        return citaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la cita."));
    }

    public Cita crearCita(CreateCitaRequest dto){
        System.out.println("Entro");
        Profesional profesional = profesionalService.getById(dto.idProfesional());

        List<Cita> citaList = citaRepository.findCitaByProfesional_Id(dto.idProfesional());

        List<Cita> pacienteCitaList = citaRepository.findCitaByPaciente_Id(dto.idPaciente());

        Paciente paciente = pacienteService.getById(dto.idPaciente());

        //No puede coincidir cita en hora y dia
        for (Cita c : citaList){
            if(c.getFechaHora().toLocalTime().getHour()==dto.fechaHora().getHour() && c.getFechaHora().toLocalDate().equals(dto.fechaHora().toLocalDate()))
                throw new RuntimeException("No se puede poner una cita en la misma hora");
        }

        for(Cita c : pacienteCitaList){
            if (c.getFechaHora().toLocalDate().equals(dto.fechaHora().toLocalDate())){
                throw new RuntimeException("Un paciente no puede tener dos citas el mismo dia.");
            }
        }


        //Pedir citas en fechas pasadas
        if(dto.fechaHora().isBefore(LocalDateTime.now())){
            throw new RuntimeException("No se pueden crear citas con fechas pasadas");
        }

        Consulta consulta = new Consulta();

        return citaRepository.save(Cita.builder()
                .profesional(profesional)
                .fechaHora(dto.fechaHora())
                .estado(dto.estado())
                .paciente(paciente)
                .consulta(consultaRepository.save(consulta))
                .build());
    }

    public Cita cancelarCita(Long id){
        Cita c = citaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado una cita con ese id."));
        if(c.getEstado()!=Estado.ATENDIDA){
            c.setEstado(Estado.CANCELADA);
        }

        return citaRepository.save(c);
    }

    public Map<Cita,Paciente>getAgenda(Long idProfesional, LocalDate fecha){
        return citaRepository.getPrueba(idProfesional,fecha);
    }

    public List<Cita>findByFechahora(LocalDateTime fechaInicio,LocalDateTime fechaFin){
        return citaRepository.findCitaByFechaHoraBetween(fechaInicio,fechaFin);
    }

    public List<Cita>getCitaByEstado(Estado estado){
        return citaRepository.findCitaByEstado(estado);
    }

    public Cita registrarConsulta(CreateConsultaDto dto,Long id) {

        Cita c = citaRepository.findById(id).orElseThrow(() -> new CitaNotFoundException("No se ha encontrado la cita."));

        if (c == null) {
            throw new RuntimeException("No se puede crear una consulta que no exista.");
        }

        if (c.getEstado() != Estado.PROGRAMADA) {
            throw new RuntimeException("No se puede crear una consulta si la cita no está programada.");
        }

        c.setEstado(Estado.ATENDIDA);

        Consulta consulta = Consulta.builder()
                .diagnostico(dto.diagnostico())
                .observaciones(dto.observaciones())
                .fecha(dto.fecha())
                .cita(c)
                .build();

        consultaRepository.save(consulta);
        c.setConsulta(consulta);

        return citaRepository.save(c);
    }

    public Page<Cita> getAll(Pageable pageable){
        return citaRepository.findAll(pageable);
    }


}
