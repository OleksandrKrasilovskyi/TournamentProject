package com.example.tournamentproject.service;

import com.example.tournamentproject.entity.Team;
import com.example.tournamentproject.repository.TeamRepository;
import com.example.tournamentproject.repository.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamManagement {

    private final TeamRepository teamRepository;
    private final TournamentRepository tournamentRepository;

    @Transactional
    public void createTeam(String teamName, String coachName,
                           String capitanName, String tournamentName) {
        final var tournament = tournamentRepository.findByTournamentName(tournamentName);

        tournament.ifPresentOrElse(tor -> {
                            final var team = new Team();
                            team.setCoachName(coachName);
                            team.setTeamName(teamName);
                            team.setCapitanName(capitanName);
                            team.setTournament(tor);
                            teamRepository.save(team);
                        },
                        () -> System.out.println("Not exists with this name " + tournamentName));
    }

    @Transactional(readOnly = true)
    public List<Team> findAllTeamsByTournamentName(String tournamentName) {
        return teamRepository.findAllByTournamentTournamentName(tournamentName);
    }

}
