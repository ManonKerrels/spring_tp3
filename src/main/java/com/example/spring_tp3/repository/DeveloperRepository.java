package com.example.spring_tp3.repository;

import com.example.spring_tp3.models.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
