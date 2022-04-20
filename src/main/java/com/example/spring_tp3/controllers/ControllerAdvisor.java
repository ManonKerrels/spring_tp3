package com.example.spring_tp3.controllers;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.models.dtos.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest servlet){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorDTO.builder()
                        .message(ex.getMessage())
                        .method(HttpMethod.resolve(servlet.getMethod()))
                        .status(404)
                        .uri(servlet.getRequestURI())
                        .build());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        System.out.println("Salut");
        return ResponseEntity.ok("ok");
    }

}
