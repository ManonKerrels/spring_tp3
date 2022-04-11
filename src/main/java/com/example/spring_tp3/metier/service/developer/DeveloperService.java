package com.example.spring_tp3.metier.service.developer;

import com.example.spring_tp3.models.dtos.DeveloperDTO;
import com.example.spring_tp3.models.forms.DeveloperForm;

import java.util.List;

public interface DeveloperService {

    public DeveloperDTO insert(DeveloperForm form);

    public DeveloperDTO getOne(Long id);

    public List<DeveloperDTO> getAll();

    public DeveloperDTO update(Long id, DeveloperForm form);

    public DeveloperDTO delete(Long id);
}
