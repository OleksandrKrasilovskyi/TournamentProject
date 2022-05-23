package com.example.tournamentproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Match {
    private String round;
    private String team1;
    private String team2;
    private String score;

}
