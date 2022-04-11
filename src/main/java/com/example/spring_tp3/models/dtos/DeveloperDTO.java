package com.example.spring_tp3.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DeveloperDTO {

    private int id;
    private String name;
    private String parentCompany;
    private LocalDate creationDate;
    private GameDTO game;

    @Data
    @Builder
    public static class GameDTO{
        private int id;
        private String title;
    }

}
