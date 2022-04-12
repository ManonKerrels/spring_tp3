package com.example.spring_tp3.metier.mapper;

import com.example.spring_tp3.models.dtos.EditorDTO;
import com.example.spring_tp3.models.entities.Editor;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.EditorForm;
import org.springframework.stereotype.Service;

@Service
public class EditorMapper {

    public EditorDTO entityToDTO(Editor entity) {
        if (entity == null) {
            return null;
        }

//        Game gameEntity = (Game) entity.getGames();
//        EditorDTO.GameDTO game = gameEntity == null ? null : new EditorDTO.GameDTO(gameEntity.getId(), gameEntity.getTitle());

        return EditorDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentCompany(entity.getParentCompany())
                .creationDate(entity.getCreationDate())
                .build();
    }

    public Editor formToEntity(EditorForm form){
        if (form == null){
            return null;
        }

        return Editor.builder()
                .id(form.getId())
                .name(form.getName())
                .parentCompany(form.getParentCompany())
                .creationDate(form.getCreationDate())
                .build();
    }


}
