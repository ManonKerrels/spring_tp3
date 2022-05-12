package com.example.spring_tp3.controllers;

import com.example.spring_tp3.exceptions.ElementNotFoundException;
import com.example.spring_tp3.metier.service.editor.EditorService;
import com.example.spring_tp3.models.dtos.EditorDTO;
import com.example.spring_tp3.models.forms.EditorForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editor")
public class EditorController {

    private final EditorService service;

    public EditorController(EditorService service) {this.service = service;}


    // --- GET ALL ---
    @GetMapping("")
    public List<EditorDTO> getAll(){ return service.getAll(); }

    // --- GET ONE ---
    @GetMapping("/{id}")
    public ResponseEntity<EditorDTO> getOne(@PathVariable Long id){
        try {
            EditorDTO dto = service.getOne(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "EditorController")
                    .body(service.getOne(id));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // --- INSERT ---
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/insert")
    public ResponseEntity<EditorDTO> insert(@RequestBody EditorForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    // --- UPDATE ---
    @PreAuthorize("isAuthenticated()")
    @PutMapping("/update/{id}")
    public ResponseEntity<EditorDTO> update(@RequestBody EditorForm form, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, form));
    }

    // --- DELETE ---
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EditorDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
