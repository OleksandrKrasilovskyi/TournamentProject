package com.example.tournamentproject.service;

import com.example.tournamentproject.dto.TournamentAnotherObject;
import com.example.tournamentproject.entity.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class Console {

    private TeamManagement teamManagement;
    private TournamentManagement tournamentManagement;
    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public void startApp() throws IOException {
        System.out.println("Welcome to Bracket Tournament");
        System.out.println("------------------------------");
        System.out.println("Enter tournament name: ");
        final var tournamentName = createTournamentName();
        tournamentManagement.createTournamentAnotherObjectMap(tournamentName);
        final var teamList = createTeamsData(tournamentName);
        Collections.shuffle(teamList);
        buildMatchesForSpecificTournament(teamList ,tournamentName);
        //TODO Вивести юзеру всі можливі наступні варіанти
        System.out.println("");
    }

    private void buildMatchesForSpecificTournament(List<Team> teamList, String tournamentName) {
        //TODO Придумати логіку, яка буде створювати матчі
    }

    private void printUpComingMatchesForSpecificTournament(String tournamentName){
        //TODO Дає можливість подивитися "предстоящие" матчі
    }

    private void playTournament(String tournamentName){

    }

    public String createTournamentName() throws IOException {
        return buffer.readLine();
    }

    public List<Team> createTeamsData(String tournamentName) throws IOException {
        System.out.println("Enter at least 4 teams:");
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        boolean condition = true;
        while (condition) {
            teamManagement.createTeam(buffer.readLine(), buffer.readLine(), buffer.readLine(), tournamentName);

            System.out.println("Enter new team names or enter 'stop' in order to finish");
            validateTeamSize(tournamentAnotherObject);
            final var stop = buffer.readLine().equalsIgnoreCase("stop");
            if (stop) {
                condition = false;
            }
        }
        return tournamentAnotherObject.getListTeam();
    }

    private void validateTeamSize(TournamentAnotherObject tournamentAnotherObject) {
        //TODO Переписати валідацію (працює некоректно, поправити)
        for (int j = 0; j < tournamentAnotherObject.getListTeam().size(); j ++) {
            if (tournamentAnotherObject.getListTeam().size() != Math.pow(2, j)) {
                System.out.println("Insufficient number of teams to draw the tournament bracket");
            } else if (tournamentAnotherObject.getListTeam().size() < 4) {
                System.out.println("Enter at least 4 teams");
            }
        }
    }
}



