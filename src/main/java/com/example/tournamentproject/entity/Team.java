package com.example.tournamentproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "team_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String teamName;

    @Column(name = "capitan_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String capitanName;

    @Column(name = "coach_name", nullable = false, updatable = false, length = 100)
    @NonNull
    private String coachName;

    //TODO learn about lazy and eager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

}
