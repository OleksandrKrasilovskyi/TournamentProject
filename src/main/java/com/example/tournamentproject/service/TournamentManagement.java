package com.example.tournamentproject.service;

import com.example.tournamentproject.dto.TournamentAnotherObject;
import com.example.tournamentproject.entity.Team;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TournamentManagement {
    @Getter
    private final Map<String, TournamentAnotherObject> tournamentAnotherObjectMap = new HashMap<>();

    public void createTournamentAnotherObjectMap(String tournamentName) {
        tournamentAnotherObjectMap.put(tournamentName, new TournamentAnotherObject());
    }

    public Team pickWinner(Team home, Team guest) {

        int homeInt = 0;
        int guestInt = 0;
        String homeString;
        String guestString;
        List<Team> nextRoundList = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {

            List<Team> thisGame = new ArrayList<>();
            thisGame.add(home);
            thisGame.add(guest);

            homeString = buffer.readLine();
            homeInt = Integer.parseInt(homeString);
            guestString = buffer.readLine();
            guestInt = Integer.parseInt(guestString);

            if (homeInt > guestInt) {
                nextRoundList.add(home);
            } else {
                nextRoundList.add(guest);
            }
        } catch (IOException e) {
            System.out.println("Error in 'TournamentManagement, pickWinner'" + e);
        }
        System.out.println("Result: " + home.toString() + ", " + guest.toString() + ", " + homeInt + ", " + guestInt);

        return nextRoundList.get(0);
    }

    public List<Team> processBracket(List<Team> currentRound) {
        List<Team> returnBracket = new ArrayList<>();

        int start = 0;
        int end = (currentRound.size() - 1);

        while (start < end) {
            Team winner = pickWinner(currentRound.get(start), currentRound.get(end));
            returnBracket.add(winner);

            start++;
            end--;
        }
        return returnBracket;
    }
}
