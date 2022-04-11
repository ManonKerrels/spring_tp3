package com.example.spring_tp3.models.forms;

import com.example.spring_tp3.models.dtos.GameDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GameForm {

    private Long id;
    private String title;
    private LocalDate releaseDate;
    private String genre;
    private boolean getLicence;
    private GameDTO.DeveloperDTO developerDTO;
    private GameDTO.EditorDTO editorDTO;

    @Data
    @AllArgsConstructor
    public static class DeveloperDTO{
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class EditorDTO{
        private Long id;
        private String name;
    }

}
