package com.example.spring_tp3.metier.service.game;

import com.example.spring_tp3.models.dtos.GameDTO;
import com.example.spring_tp3.models.forms.GameForm;

import java.util.List;

public interface GameService {

    public GameDTO insert(GameForm form);

    public GameDTO getOne(Long id);

    public List<GameDTO> getAll();

    public GameDTO update(Long id, GameForm form);

    public GameDTO delete(Long id);

    public GameDTO updateDeveloper(Long id, Long idDeveloper);
}
