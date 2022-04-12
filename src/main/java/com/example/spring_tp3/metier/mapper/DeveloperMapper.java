package com.example.spring_tp3.metier.mapper;

import com.example.spring_tp3.models.dtos.DeveloperDTO;
import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.forms.DeveloperForm;
import org.springframework.stereotype.Service;

@Service
public class DeveloperMapper {

    public DeveloperDTO entityToDTO(Developer entity) {
        if (entity == null) {
            return null;
        }

//        Game gameEntity = (Game) entity.getGames();
//        DeveloperDTO.GameDTO game = gameEntity == null ? null : new DeveloperDTO.GameDTO(gameEntity.getId(), gameEntity.getTitle());

        return DeveloperDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentCompany(entity.getParentCompany())
                .creationDate(entity.getCreationDate())
                .build();
    }

    public Developer formToEntity(DeveloperForm form) {
        if (form == null) {
            return null;
        }

        return Developer.builder()
                .id(form.getId())
                .name(form.getName())
                .parentCompany(form.getParentCompany())
                .creationDate(form.getCreationDate())
                .build();
    }
}
