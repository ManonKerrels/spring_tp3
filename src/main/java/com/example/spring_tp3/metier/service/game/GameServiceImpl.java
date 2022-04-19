package com.example.spring_tp3.metier.service.game;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.mapper.GameMapper;
import com.example.spring_tp3.models.dtos.GameDTO;
import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.forms.GameForm;
import com.example.spring_tp3.repository.DeveloperRepository;
import com.example.spring_tp3.repository.GameRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService{

    private final GameRepository repository;
    private final GameMapper mapper;
    private final DeveloperRepository developerRepository;

    public GameServiceImpl(GameRepository repository, GameMapper mapper, DeveloperRepository developerRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.developerRepository = developerRepository;
    }

    @Override
    public GameDTO insert(GameForm form) {
        Game entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public GameDTO getOne(Long id) {
        GameDTO dto = repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        return dto;
    }

    @Override
    public List<GameDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public GameDTO update(Long id, GameForm form) {
        Game entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        entity.setTitle(form.getTitle());
        entity.setReleaseDate(form.getReleaseDate());
        entity.setGenre(form.getGenre());
        entity.setGetLicence(form.isGetLicence());
//        entity.setDeveloper(form.getDeveloper());
//        entity.setEditor(form.getEditor());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public GameDTO delete(Long id) {
        GameDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }

    @Override
    public GameDTO updateDeveloper(Long id, Long idDeveloper) {
        Game game = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        Developer developer = developerRepository.findById(idDeveloper)
                .orElseThrow(() -> new ElementNotFoundException(idDeveloper, Developer.class));
        game.setDeveloper(developer);
        return mapper.entityToDTO(game);
    }
}
