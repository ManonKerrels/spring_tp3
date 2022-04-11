package com.example.spring_tp3.metier.service.developer;

import com.example.spring_tp3.models.dtos.DeveloperDTO;
import com.example.spring_tp3.models.forms.DeveloperForm;

import java.util.List;

public class DeveloperServiceMock implements DeveloperService{
    @Override
    public DeveloperDTO insert(DeveloperForm form) {
        return null;
    }

    @Override
    public DeveloperDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<DeveloperDTO> getAll() {
        return null;
    }

    @Override
    public DeveloperDTO update(Long id, DeveloperForm form) {
        return null;
    }

    @Override
    public DeveloperDTO delete(Long id) {
        return null;
    }
}
