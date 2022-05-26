package com.example.tournamentproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Match {
    private String round;
    private String Team_1;
    private String Team_2;
    private String score;
}
