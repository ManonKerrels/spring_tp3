package com.example.spring_tp3.models.forms;

import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Editor;
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
    private Developer developer;
    private Editor editor;

    @Data
    @AllArgsConstructor
    public static class Developer {
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class Editor {
        private Long id;
        private String name;
    }

}
