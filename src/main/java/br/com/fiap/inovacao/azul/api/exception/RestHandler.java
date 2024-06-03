package br.com.fiap.inovacao.azul.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> erro404(){
        return ResponseEntity.notFound().build();
    }
}
