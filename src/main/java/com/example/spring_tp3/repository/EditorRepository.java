package com.example.spring_tp3.repository;

import com.example.spring_tp3.models.entities.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorRepository extends JpaRepository<Editor, Long> {
}
