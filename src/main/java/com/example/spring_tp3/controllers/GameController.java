package com.example.spring_tp3.controllers;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.service.game.GameService;
import com.example.spring_tp3.models.dtos.GameDTO;
import com.example.spring_tp3.models.forms.GameForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }


    // --- GET ALL ---
    @GetMapping("")
    public List<GameDTO> getAll(){
        return service.getAll();
    }

    // --- GET ONE ---
    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getOne(@PathVariable Long id){
        try {
            GameDTO dto = service.getOne(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getOne(id));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // --- INSERT ---
    @PostMapping("/insert")
    public ResponseEntity<GameDTO> insert(@RequestBody GameForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    // --- UPDATE ---
    @PutMapping("/update/{id}")
    public ResponseEntity<GameDTO> update(@RequestBody GameForm form, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, form));
    }

    // --- DELETE ---
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GameDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }


    // --- UPDATE DEVELOPER ---
    @PutMapping("/updateDev/{id}/developer/{idDeveloper}")
    public ResponseEntity<GameDTO> updateDeveloper(@PathVariable Long id, @PathVariable Long idDeveloper){
        return ResponseEntity.ok(service.updateDeveloper(id, idDeveloper));
    }

    // --- UPDATE EDITOR ---
    @PutMapping("/updateEdit/{id}/editor/{idEditor}")
    public ResponseEntity<GameDTO> updateEditor(@PathVariable Long id, @PathVariable Long idEditor){
        return ResponseEntity.ok(service.updateEditor(id, idEditor));
    }

}
