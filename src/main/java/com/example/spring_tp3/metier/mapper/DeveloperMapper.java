package com.example.spring_tp3.metier.mapper;

import com.example.spring_tp3.models.dtos.DeveloperDTO;
import com.example.spring_tp3.models.dtos.GameDTO;
import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.DeveloperForm;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperMapper {

    public DeveloperDTO entityToDTO(Developer entity) {
        if (entity == null) {
            return null;
        }

        return DeveloperDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentCompany(entity.getParentCompany())
                .creationDate(entity.getCreationDate())
                .game(entity.getGames() == null ? null : entity.getGames().stream().map(DeveloperDTO.GameDTO::of).toList())
                .build();
    }

    public Developer formToEntity(DeveloperForm form) {
        if (form == null) {
            return null;
        }

        return Developer.builder()
                .name(form.getName())
                .parentCompany(form.getParentCompany())
                .creationDate(form.getCreationDate())
                .build();
    }
}
