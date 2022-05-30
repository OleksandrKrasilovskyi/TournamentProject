package com.example.tournamentproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @Column(nullable = false, updatable = false, length = 20)
    @NonNull
    private String round;

    @Column(name = "first_team", length = 100)
    private String firstTeam;

    @Column(name = "second_team", length = 100)
    private String secondTeam;

    @Column
    private String score;

    //TODO learn about lazy and eager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

}
