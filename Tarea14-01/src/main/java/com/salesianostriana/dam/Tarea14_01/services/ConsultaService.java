package com.salesianostriana.dam.Tarea14_01.services;

import com.salesianostriana.dam.Tarea14_01.dtos.consulta.ConsultaDtoCmd;
import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.models.Consulta;
import com.salesianostriana.dam.Tarea14_01.repository.CitaRepository;
import com.salesianostriana.dam.Tarea14_01.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final CitaService citaService;
    private final CitaRepository citaRepository;

    public Consulta registrarConsulta(ConsultaDtoCmd dto){

        Cita c = citaService.getById(dto.idCita());

        if(c == null){
            throw new RuntimeException("No se puede crear una consulta que no exista.");
        }


        

        return consultaRepository.save(Consulta.builder()
                .diagnostico(dto.diagnostico())
                .observaciones(dto.observaciones())
                .fecha(dto.fecha())
                .cita(c)
                .build());
    }
}
