package com.example.tournamentproject.service;

import com.example.tournamentproject.entity.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamManagement {
    private TournamentManagement tournamentManagement;

    public void createTeam(String teamName, String coachName, String capitanName, String tournamentName) {
        Team team = new Team(teamName, capitanName, coachName);
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        tournamentAnotherObject.getListTeam().add(team);
        }
    }
