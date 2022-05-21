package com.example.TournamentProject;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
@AllArgsConstructor
public class Console {

    private final TeamManagement teamManagement;
    private final TournamentManagement tournamentManagement;

    public void startApp() {
        System.out.println("Welcome to Bracket Tournament");
        System.out.println("------------------------------");
    }
}


