package com.example.spring_tp3.metier.service.developer;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.mapper.DeveloperMapper;
import com.example.spring_tp3.models.dtos.DeveloperDTO;
import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.DeveloperForm;
import com.example.spring_tp3.repository.DeveloperRepository;
import com.example.spring_tp3.repository.GameRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService{

    private final DeveloperRepository repository;
    private final DeveloperMapper mapper;
    private final GameRepository gameRepository;

    public DeveloperServiceImpl(DeveloperRepository repository, DeveloperMapper mapper, GameRepository gameRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.gameRepository = gameRepository;
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
                .orElseThrow(() -> new ElementNotFoundException(id, Developer.class));
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
                .orElseThrow(() -> new ElementNotFoundException(id, Developer.class));
        entity.setName(form.getName());
        entity.setParentCompany(form.getParentCompany());
        entity.setCreationDate(form.getCreationDate());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public DeveloperDTO delete(Long id) {
        Developer entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Developer.class));
        for (Game game : entity.getGames()){
            game.setDeveloper(null);
            gameRepository.save(game);
        }
        DeveloperDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;

    }


    //updateGame + nouveau form
    //insertGame + nouveau form
}
