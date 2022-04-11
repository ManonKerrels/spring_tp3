package com.example.spring_tp3.metier.service.developer;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.mapper.DeveloperMapper;
import com.example.spring_tp3.models.dtos.DeveloperDTO;
import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.DeveloperForm;
import com.example.spring_tp3.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService{

    private final DeveloperRepository repository;
    private final DeveloperMapper mapper;

    public DeveloperServiceImpl(DeveloperRepository repository, DeveloperMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DeveloperDTO insert(DeveloperForm form) {
        Developer entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public DeveloperDTO getOne(Long id) {
        DeveloperDTO dto = repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        return dto;
    }

    @Override
    public List<DeveloperDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public DeveloperDTO update(Long id, DeveloperForm form) {
        Developer entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        entity.setName(form.getName());
        entity.setParentCompany(form.getParentCompany());
        entity.setCreationDate(form.getCreationDate());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public DeveloperDTO delete(Long id) {
        DeveloperDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
