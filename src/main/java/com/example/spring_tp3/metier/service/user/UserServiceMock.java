package com.example.spring_tp3.metier.service.user;

import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.forms.UserConnectForm;
import com.example.spring_tp3.models.forms.UserForm;

import java.util.List;

public class UserServiceMock implements UserService{
    @Override
    public UserDTO insert(UserForm form) {
        return null;
    }

    @Override
    public UserDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public UserDTO update(Long id, UserForm form) {
        return null;
    }

    @Override
    public UserDTO delete(Long id) {
        return null;
    }

    @Override
    public UserDTO getByUsername(UserConnectForm form) {
        return null;
    }

    @Override
    public UserDTO getByUsernameOnly(String username) {return null;}

    @Override
    public UserDTO addGameToFavorites(Long id, Long idGame) {
        return null;
    }

}
