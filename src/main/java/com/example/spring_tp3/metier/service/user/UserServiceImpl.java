package com.example.spring_tp3.metier.service.user;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.mapper.UserMapper;
import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.entities.User;
import com.example.spring_tp3.models.forms.UserConnectForm;
import com.example.spring_tp3.models.forms.UserForm;
import com.example.spring_tp3.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO insert(UserForm form) {
        User entity = userMapper.formToEntity(form);
        entity.setNotLocked(true);
        entity = userRepository.save(entity);
        return userMapper.entityToDTO(entity);
    }

    @Override
    public UserDTO getOne(Long id) {
        UserDTO dto = userRepository.findById(id)
                .map(userMapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        return dto;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDTO)
                .toList();
    }

    @Override
    public UserDTO update(Long id, UserForm form) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        entity.setUsername(form.getUsername());
        entity.setPassword(form.getPassword());
        entity.setEmail(form.getEmail());
        entity = userRepository.save(entity);
        return userMapper.entityToDTO(entity);
    }

    @Override
    public UserDTO delete(Long id) {
        UserDTO dto = getOne(id);
        userRepository.deleteById(id);
        return dto;
    }

    @Override
    public UserDTO getByUsername(UserConnectForm form) {
        System.out.println(form.getUsername());
        UserDTO dto = userRepository.findByUsername(form.getUsername())
                .map(userMapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(0, User.class));
        return dto;
    }
}
