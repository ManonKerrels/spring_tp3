package com.example.spring_tp3.metier.service.editor;

import com.example.spring_tp3.models.dtos.EditorDTO;
import com.example.spring_tp3.models.forms.EditorForm;

import java.util.List;

public interface EditorService {
    public EditorDTO insert(EditorForm form);

    public EditorDTO getOne(Long id);

    public List<EditorDTO> getAll();

    public EditorDTO update(Long id, EditorForm form);

    public EditorDTO delete(Long id);
}
