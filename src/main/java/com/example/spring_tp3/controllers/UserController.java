package com.example.spring_tp3.controllers;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.service.user.UserService;
import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.entities.User;
import com.example.spring_tp3.models.forms.UserConnectForm;
import com.example.spring_tp3.models.forms.UserForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // --- GET ALL ---
    @GetMapping("")
    public List<UserDTO> getAll(){
        return service.getAll();
    }

    // --- GET ONE ---
    @PostMapping("/login")
    public ResponseEntity<UserDTO> getOne(@RequestBody UserConnectForm form){
        try {
            UserDTO dto = service.getByUsername(form);
            return ResponseEntity.ok(dto);
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // --- INSERT ---
    @PostMapping("/insert")
    public ResponseEntity<UserDTO> insert(@RequestBody UserForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    // --- UPDATE ---
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserForm form, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, form));
    }

    // --- DELETE ---
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    // --- ADD GAME TO FAVORITES ---
    @PutMapping("/update/{id}/fav/{idGame}")
    public ResponseEntity<UserDTO> addGameToFavorites(@RequestBody UserConnectForm form, @PathVariable Long id, @PathVariable Long idGame){
        try{
            UserDTO dto = service.getByUsername(form);
            return ResponseEntity.ok(service.addGameToFavorites(id, idGame));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
