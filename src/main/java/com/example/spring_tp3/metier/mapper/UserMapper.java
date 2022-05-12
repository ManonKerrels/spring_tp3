package com.example.spring_tp3.metier.mapper;

import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.User;
import com.example.spring_tp3.models.forms.UserForm;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO entityToDTO(User entity){
        if (entity == null){
            return null;
        }

        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .roles(entity.getRoles())
                .games(entity.getGames() == null ? null : entity.getGames().stream().map(UserDTO.GameDTO::of).toList())
                .build();
    }

    public User formToEntity (UserForm form) {
        if (form == null) {
            return null;
        }

        return User.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .email(form.getEmail())
                .build();
    }



}
