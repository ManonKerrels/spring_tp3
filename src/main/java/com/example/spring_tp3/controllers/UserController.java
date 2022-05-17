package com.example.spring_tp3.controllers;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.service.LoginService;
import com.example.spring_tp3.metier.service.user.UserService;
import com.example.spring_tp3.models.dtos.JwtDTO;
import com.example.spring_tp3.models.dtos.UserDTO;
import com.example.spring_tp3.models.forms.UserConnectForm;
import com.example.spring_tp3.models.forms.UserForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final LoginService loginService;
    private final UserService service;

    public UserController(LoginService loginService, UserService service) {
        this.loginService = loginService;
        this.service = service;
    }

    // --- GET ALL ---
    @GetMapping("")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDTO> getAll(){
        return service.getAll();
    }

    // --- LOGIN ---
    @PostMapping("/login")
    public JwtDTO login(@RequestBody UserConnectForm form){
        return loginService.login(form);
    }

    // --- GET ONE ---
    @GetMapping(params = {"username"})
//    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserDTO> getOne(@RequestParam String username){
        try {
            UserDTO dto = service.getByUsernameOnly(username);
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
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserForm form, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, form));
    }

    // --- DELETE ---
//    @PreAuthorize("isAuthenticated()")
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }


    // --- ADD GAME TO FAVORITES ---
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @PatchMapping ("/update/{id}/fav/{idGame}")
    public ResponseEntity<UserDTO> addGameToFavorites(@PathVariable Long id, @PathVariable Long idGame){
        try{
            return ResponseEntity.ok(service.addGameToFavorites(id, idGame));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
