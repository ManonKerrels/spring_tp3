package com.example.spring_tp3.models.forms;

import com.example.spring_tp3.models.dtos.DeveloperDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DeveloperForm {

    private int id;
    private String name;
    private String parentCompany;
    private LocalDate creationDate;
    private DeveloperDTO.GameDTO game;

    @Data
    @Builder
    public static class GameDTO{
        private int id;
        private String title;
    }

}
