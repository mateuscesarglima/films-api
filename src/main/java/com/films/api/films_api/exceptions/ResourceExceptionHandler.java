package com.films.api.films_api.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandartError> databaseError(DatabaseException e, HttpServletRequest request) {
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InsertException.class)
    public ResponseEntity<StandartError> insertionError(InsertException e, HttpServletRequest request) {
        String error = "Insertion error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
