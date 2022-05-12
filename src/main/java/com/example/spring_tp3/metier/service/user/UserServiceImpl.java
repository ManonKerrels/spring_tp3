package com.example.spring_tp3.metier.service.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.spring_tp3.config.JWTProperties;
import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.mapper.UserMapper;
import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.models.entities.User;
import com.example.spring_tp3.models.forms.UserConnectForm;
import com.example.spring_tp3.models.forms.UserForm;
import com.example.spring_tp3.repository.GameRepository;
import com.example.spring_tp3.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final GameRepository gameRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, GameRepository gameRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.gameRepository = gameRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDTO insert(UserForm form) {
        User entity = userMapper.formToEntity(form);
        encoder.encode(form.getPassword());
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
        entity.setPassword(encoder.encode(form.getPassword()));
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

    @Override
    public UserDTO addGameToFavorites(Long id, Long idGame){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, Game.class));
        Game game = gameRepository.findById(idGame)
                .orElseThrow(() -> new ElementNotFoundException(idGame, Game.class));
        entity.getGames().add(game);
        entity = userRepository.save(entity);
        return userMapper.entityToDTO(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new ElementNotFoundException(username, User.class));
    }
}
