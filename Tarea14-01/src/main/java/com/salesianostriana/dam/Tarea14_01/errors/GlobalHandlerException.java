package com.salesianostriana.dam.Tarea14_01.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException extends RuntimeException{

    @ExceptionHandler(EntityNotFound.class)
    public ProblemDetail handlerEntityNotFound(EntityNotFound ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,"No se encuentra la entidad");
        problemDetail.setTitle("No se encuentra la entidad");
        return problemDetail;
    }
}
