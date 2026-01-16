package com.salesianostriana.dam.Tarea14_01.controllers;

import com.salesianostriana.dam.Tarea14_01.dtos.cita.CItaDetailDto;
import com.salesianostriana.dam.Tarea14_01.dtos.cita.CreateCitaRequest;
import com.salesianostriana.dam.Tarea14_01.dtos.consulta.CreateConsultaDto;
import com.salesianostriana.dam.Tarea14_01.models.Cita;
import com.salesianostriana.dam.Tarea14_01.repository.CitaRepository;
import com.salesianostriana.dam.Tarea14_01.services.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    @PostMapping("")
    public ResponseEntity<CItaDetailDto> create(@RequestBody CreateCitaRequest dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(CItaDetailDto.of(citaService.crearCita(dto)));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<CItaDetailDto> cancelar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(CItaDetailDto.of(citaService.cancelarCita(id)));
    }

    @PostMapping("/{id}/consulta")
    public ResponseEntity<CItaDetailDto>createConsulta(@PathVariable Long id, @RequestBody CreateConsultaDto createConsultaDto){
        return ResponseEntity.status(HttpStatus.OK).body(CItaDetailDto.of(citaService.registrarConsulta(createConsultaDto,id)));
    }

    @GetMapping("")
    public Page<CItaDetailDto> getAll(Pageable pageable){
        return citaService.getAll(pageable).map(CItaDetailDto::of);
    }

  
}
