package com.example.spring_tp3.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DeveloperDTO {

    private Long id;
    private String name;
    private String parentCompany;
    private LocalDate creationDate;
    private GameDTO game;

    @Data
    @AllArgsConstructor
    public static class GameDTO{
        private Long id;
        private String title;
    }

}
