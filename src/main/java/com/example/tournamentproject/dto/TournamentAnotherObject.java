package com.example.tournamentproject.dto;


import com.example.tournamentproject.entity.Match;
import com.example.tournamentproject.entity.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TournamentAnotherObject {
    private List<Team> listTeam = new ArrayList<>();
    private List<Match> listMatch = new ArrayList<>();
}
