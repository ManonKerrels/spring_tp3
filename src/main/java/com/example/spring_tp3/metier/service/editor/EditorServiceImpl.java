package com.example.spring_tp3.metier.service.editor;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.mapper.EditorMapper;
import com.example.spring_tp3.models.dtos.EditorDTO;
import com.example.spring_tp3.models.entities.Editor;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.EditorForm;
import com.example.spring_tp3.repository.EditorRepository;
import com.example.spring_tp3.repository.GameRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EditorServiceImpl implements EditorService{

    private final EditorRepository repository;
    private final EditorMapper mapper;
    private final GameRepository gameRepository;

    public EditorServiceImpl(EditorRepository repository, EditorMapper mapper, GameRepository gameRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.gameRepository = gameRepository;
    }

    @Override
    public EditorDTO insert(EditorForm form) {
        Editor entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public EditorDTO getOne(Long id) {
        EditorDTO dto = repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, Editor.class));
        return dto;
    }

    @Override
    public List<EditorDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public EditorDTO update(Long id, EditorForm form) {
        Editor entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Editor.class));
        entity.setName(form.getName());
        entity.setCreationDate(form.getCreationDate());
        entity.setParentCompany(form.getParentCompany());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public EditorDTO delete(Long id) {
        Editor entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Editor.class));
        for (Game game : entity.getGames()){
            game.setEditor(null);
            gameRepository.save(game);
        }
        EditorDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
