package com.example.TournamentProject;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class TournamentManagement {

    public void welcomeToTournament() {
        System.out.println("Enter tournament name please");
    }
    public void createTournamentName() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
