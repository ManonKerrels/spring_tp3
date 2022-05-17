package com.example.spring_tp3.metier.service.user;

import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.forms.UserConnectForm;
import com.example.spring_tp3.models.forms.UserForm;

import java.util.List;

public interface UserService {

    UserDTO insert(UserForm form);

    UserDTO getOne(Long id);

    List<UserDTO> getAll();

    UserDTO update(Long id, UserForm form);

    UserDTO delete(Long id);

    UserDTO getByUsername(UserConnectForm form);

    UserDTO getByUsernameOnly(String username);

    UserDTO addGameToFavorites(Long id, Long idGame);

    UserDTO deleteGameFromFavorites(Long id, Long idGame);


}
