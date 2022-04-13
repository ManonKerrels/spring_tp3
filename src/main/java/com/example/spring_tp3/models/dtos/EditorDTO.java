package com.example.spring_tp3.models.dtos;

import com.example.spring_tp3.models.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class EditorDTO {

    private Long id;
    private String name;
    private String parentCompany;
    private LocalDate creationDate;
    private List<GameDTO> game;

    @Data
    public static class GameDTO{
        private final Long id;
        private final String title;

        public static GameDTO of(Game entity){
            if (entity == null){
                return null;
            }
            return new GameDTO(entity.getId(), entity.getTitle());
        }
    }

}
