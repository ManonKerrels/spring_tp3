package com.example.spring_tp3.models.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GameForm {

    private String title;
    private LocalDate releaseDate;
    private String genre;
    private String portage;
    private boolean getLicence;
    private DeveloperDTO developer;
    private EditorDTO editor;

    @Data
    @AllArgsConstructor
    public static class DeveloperDTO {
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class EditorDTO {
        private Long id;
        private String name;
    }

}
