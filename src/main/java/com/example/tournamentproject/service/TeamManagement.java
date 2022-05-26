package com.example.tournamentproject.service;

import com.example.tournamentproject.entity.Match;
import com.example.tournamentproject.entity.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamManagement {
    private TournamentManagement tournamentManagement;

    public void createTeam(String teamName, String capitanName, String coachName, String tournamentName) {
        Team team = new Team(teamName, capitanName, coachName);
        final var tournamentSomethingMap = tournamentManagement.getTournamentSomethingMap();
        final var something = tournamentSomethingMap.get(tournamentName);
        something.getListTeam().add(team);
    }

    public void createMatch(String round, String team1, String team2, String score, String tournamentName) {
        Match match = new Match(round, team1, team2, score);
        final var tournamentSomethingMap = tournamentManagement.getTournamentSomethingMap();
        final var something = tournamentSomethingMap.get(tournamentName);
        something.getListMatch().add(match);
    }
}

