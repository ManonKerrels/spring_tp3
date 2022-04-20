package com.example.spring_tp3.metier.service.user;

import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.forms.UserForm;

import java.util.List;

public interface UserService {

    public UserDTO insert(UserForm form);

    public UserDTO getOne(Long id);

    public List<UserDTO> getAll();

    public UserDTO update(Long id, UserForm form);

    public UserDTO delete(Long id);

}
