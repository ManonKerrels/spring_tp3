package com.example.spring_tp3.metier.mapper;

import com.example.spring_tp3.models.dtos.EditorDTO;
import com.example.spring_tp3.models.entities.Editor;
import com.example.spring_tp3.models.forms.EditorForm;
import org.springframework.stereotype.Service;

@Service
public class EditorMapper {

    public EditorDTO entityToDTO(Editor entity) {
        if (entity == null) {
            return null;
        }

        return EditorDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentCompany(entity.getParentCompany())
                .creationDate(entity.getCreationDate())
                .game((EditorDTO.GameDTO) entity.getList())
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
