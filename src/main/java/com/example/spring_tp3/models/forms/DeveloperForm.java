package com.example.spring_tp3.models.forms;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DeveloperForm {

    private Long id;
    private String name;
    private String parentCompany;
    private LocalDate creationDate;
    private GameDTO game;

    @Data
    @Builder
    public static class GameDTO{
        private Long id;
        private String title;
    }

}
