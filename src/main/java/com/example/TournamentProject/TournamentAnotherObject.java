package com.example.TournamentProject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TournamentAnotherObject {
    private List<Team> listTeam;
    private List<Match> listMatch;
}
