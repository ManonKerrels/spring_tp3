package com.example.spring_tp3.metier.service.editor;

import com.example.spring_tp3.models.dtos.EditorDTO;
import com.example.spring_tp3.models.forms.EditorForm;

import java.util.List;

public class EditorServiceMock implements EditorService{
    @Override
    public EditorDTO insert(EditorForm form) {
        return null;
    }

    @Override
    public EditorDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<EditorDTO> getAll() {
        return null;
    }

    @Override
    public EditorDTO update(Long id, EditorForm form) {
        return null;
    }

    @Override
    public EditorDTO delete(Long id) {
        return null;
    }
}
