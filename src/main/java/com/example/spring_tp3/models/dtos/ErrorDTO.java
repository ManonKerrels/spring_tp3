package com.example.spring_tp3.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
@Builder
public class ErrorDTO {

    private final String message;
    private final int status;
    private final String uri;
    private final HttpMethod method;
    private final Map<String, Object> infos = new HashMap<>();


    public ErrorDTO(String message, String uri, HttpMethod method) {
        this.message = message;
        this.status = 400;
        this.uri = uri;
        this.method = method;
    }

    public ErrorDTO(String message, int status, String uri, Map<String, Object> infos, HttpMethod method) {
        this.message = message;
        this.status = 400;
        this.uri = uri;
        this.infos.putAll(infos);
        this.method = method;
    }
}