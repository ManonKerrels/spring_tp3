package com.example.spring_tp3.metier.mapper;

import com.example.spring_tp3.models.dtos.GameDTO;
import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Editor;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.GameForm;
import org.springframework.stereotype.Service;

@Service
public class GameMapper {

    public GameDTO entityToDTO(Game entity){
        if (entity == null){
            return null;
        }

        Developer developerEntity = entity.getDeveloper();
        GameDTO.DeveloperDTO developer = developerEntity == null ? null : new GameDTO.DeveloperDTO(developerEntity.getId(), developerEntity.getName());

        Editor editorEntity = entity.getEditor();
        GameDTO.EditorDTO editor = developerEntity == null ? null : new GameDTO.EditorDTO(editorEntity.getId(), editorEntity.getName());

        return GameDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .releaseDate(entity.getReleaseDate())
                .genre(entity.getGenre())
                .getLicence(entity.isGetLicence())
                .developer(developer)
                .editor(editor)
                .build();
    }

    public Game formToEntity(GameForm form){
        if (form == null){
            return null;
        }
        return Game.builder()
                .id(form.getId())
                .title(form.getTitle())
                .releaseDate(form.getReleaseDate())
                .genre(form.getGenre())
                .getLicence(form.isGetLicence())
                .build();
    }

}
