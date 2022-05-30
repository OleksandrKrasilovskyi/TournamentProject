package com.example.tournamentproject.service;

import com.example.tournamentproject.entity.Tournament;
import com.example.tournamentproject.repository.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class TournamentManagement {

    private final TournamentRepository tournamentRepository;

    @Transactional
    public void createTournament(String tournamentName) {
        final var tournament = new Tournament();
        tournament.setMatches(new HashSet<>());
        tournament.setTeams(new HashSet<>());
        tournament.setTournamentName(tournamentName);

        tournamentRepository.save(tournament);
    }

    public void createMatch(String round, String team1, String team2, String score, String tournamentName) {
//        final var match = new Match(round, team1, team2, score);
//        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
//        tournamentAnotherObject.getListMatch().add(match);
    }

}
