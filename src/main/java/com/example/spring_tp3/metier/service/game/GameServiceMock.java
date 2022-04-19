package com.example.spring_tp3.metier.service.game;

import com.example.spring_tp3.models.dtos.GameDTO;
import com.example.spring_tp3.models.forms.GameForm;

import java.util.List;

public class GameServiceMock implements GameService{
    @Override
    public GameDTO insert(GameForm form) {
        return null;
    }

    @Override
    public GameDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<GameDTO> getAll() {
        return null;
    }

    @Override
    public GameDTO update(Long id, GameForm form) {
        return null;
    }

    @Override
    public GameDTO delete(Long id) {
        return null;
    }

    @Override
    public GameDTO updateDeveloper(Long id, Long idDeveloper) {
        return null;
    }
}
