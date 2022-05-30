package com.example.tournamentproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Long id;

    @Column(name = "tournament_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String tournamentName;

    @OneToMany(mappedBy = "tournament")
    private Set<Team> teams;

    @OneToMany(mappedBy = "tournament")
    private Set<Match> matches;

}