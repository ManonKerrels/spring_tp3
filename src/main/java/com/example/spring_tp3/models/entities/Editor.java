package com.example.spring_tp3.models.entities;

import lombok.*;
import org.apache.tomcat.jni.Local;

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
@Table(name = "editor")
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editor_id", nullable = false)
    private Long id;

    @Column(name = "editor_name", nullable = false, length = 50)
    private String name;

    @Column(name = "editor_company", length = 50)
    private String parentCompany;

    @Column(name = "editor_creationDate")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "editor", cascade = CascadeType.REFRESH)
    private List<Game> games = new ArrayList<>();

}
