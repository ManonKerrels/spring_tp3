package com.example.spring_tp3.controllers;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.service.developer.DeveloperService;
import com.example.spring_tp3.models.dtos.DeveloperDTO;
import com.example.spring_tp3.models.dtos.EditorDTO;
import com.example.spring_tp3.models.forms.DeveloperForm;
import com.example.spring_tp3.models.forms.EditorForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    private final DeveloperService service;

    public DeveloperController(DeveloperService service) { this.service = service; }

    // --- GET ALL ---
    @GetMapping("")
    public List<DeveloperDTO> getAll(){ return service.getAll(); }

    // --- GET ONE ---
    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> getOne(@PathVariable Long id){
        try {
            DeveloperDTO dto = service.getOne(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "EditorController")
                    .body(service.getOne(id));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // --- INSERT ---
    @PostMapping("/insert")
    public ResponseEntity<DeveloperDTO> insert(@RequestBody DeveloperForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    // --- UPDATE ---
    @PutMapping("/update/{id}")
    public ResponseEntity<DeveloperDTO> update(@RequestBody DeveloperForm form, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, form));
    }

    // --- DELETE ---
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeveloperDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
