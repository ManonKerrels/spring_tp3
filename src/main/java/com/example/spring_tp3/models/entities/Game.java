package com.example.spring_tp3.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "release")
    private LocalDate releaseDate;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "portage", length = 150)
    private String portage;

    @NonNull
    private boolean getLicence;

    @ManyToOne
    @JoinColumn
    private Editor editor;

    @ManyToOne
    @JoinColumn
    private Developer developer;

    @ManyToMany(mappedBy = "games", cascade = CascadeType.REFRESH)
    private List<User> user;

}
