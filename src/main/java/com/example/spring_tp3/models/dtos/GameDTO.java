package com.example.spring_tp3.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GameDTO {

    private Long id;
    private String title;
    private LocalDate releaseDate;
    private String genre;
    private boolean getLicence;
    private DeveloperDTO developer;
    private EditorDTO editor;

    @Data
    @AllArgsConstructor
    public static class DeveloperDTO{
        private int id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class EditorDTO{
        private int id;
        private String name;
    }

}
