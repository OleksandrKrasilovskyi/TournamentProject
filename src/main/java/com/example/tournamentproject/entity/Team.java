package com.example.tournamentproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Team {
    private String teamName;
    private String capitanName;
    private String coachName;
}
