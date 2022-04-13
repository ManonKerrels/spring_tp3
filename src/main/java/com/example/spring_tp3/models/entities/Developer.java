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
    @Column(name = "developer_id", nullable = false)
    private Long id;

    @Column(name = "developer_name", nullable = false, length = 50)
    private String name;

    @Column(name = "developer_company", length = 50)
    private String parentCompany;

    @Column(name = "developer_creationDate")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<Game> games = new ArrayList<>();

}
