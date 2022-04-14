package com.example.spring_tp3.repository;

import com.example.spring_tp3.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

//    @Query(value = "SELECT * FROM games WHERE DEVELOPER_DEVELOPER_ID = ?1", nativeQuery= true)
//    Optional<Game> findByDev(Long idDev);
}
