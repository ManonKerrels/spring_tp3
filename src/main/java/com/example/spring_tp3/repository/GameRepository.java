package com.example.spring_tp3.repository;

import com.example.spring_tp3.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
