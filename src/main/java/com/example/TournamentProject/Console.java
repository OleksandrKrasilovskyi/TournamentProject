package com.example.TournamentProject;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class Console {

    private TeamManagement teamManagement;
    private TournamentManagement tournamentManagement;

    public void startApp() {
        System.out.println("Welcome to Bracket Tournament");
        System.out.println("------------------------------");
        tournamentManagement.getTournamentName();
        tournamentManagement.createTournamentName();
    }

    public void testApp() {
        ArrayList<Team> roundOne = new ArrayList<>();
        teamManagement.createTeam(roundOne);
        System.out.println("Semi-final");
        System.out.println("-----------------");

//        ArrayList<Team> roundTwo = tournamentManagement.processBracket(roundOne);
//        System.out.println("Final");
//        System.out.println("----------------");

        ArrayList<Team> result = tournamentManagement.processBracket(roundOne);
        System.out.println("Winner is: "  + result.get(0));
    }
}


