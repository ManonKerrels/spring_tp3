package com.example.spring_tp3.models.dtos;

import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.UserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private List<GameDTO> games;

    @Data
    @AllArgsConstructor
    public static class GameDTO {
        private Long id;
        private String title;

        public static UserDTO.GameDTO of(Game entity){
            if (entity == null){
                return null;
            }
            return new UserDTO.GameDTO(entity.getId(), entity.getTitle());
        }
    }

}
