package com.example.spring_tp3.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "company", length = 50)
    private String parentCompany;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "developer")
    private List<Game> games = new ArrayList<>();

}
