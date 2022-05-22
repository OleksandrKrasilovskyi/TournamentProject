package com.example.TournamentProject;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentManagement {

    public void getTournamentName() {
        System.out.println("Enter tournament name:");
    }

    public String createTournamentName() {
        String tournamentName = null;
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            tournamentName = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tournamentName;
    }

    public Team pickWinner(Team home, Team guest) {

        int homeInt = 0;
        int guestInt = 0;
        String homeString;
        String guestString;
        List<Team> nextRoundList = new ArrayList<>();

        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            List<Team> thisGame = new ArrayList<>();
            thisGame.add(home);
            thisGame.add(guest);

            homeString = buffer.readLine();
            homeInt = Integer.parseInt(homeString);
            guestString = buffer.readLine();
            guestInt = Integer.parseInt(guestString);

            if (homeInt > guestInt) {
                nextRoundList.add(home);
            } else nextRoundList.add(guest);


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Result: " + home.toString() + ", " + guest.toString() + ", " + homeInt + ", " + guestInt);

        return nextRoundList.get(0);
    }

    public ArrayList<Team> processBracket(ArrayList<Team> thisRound) {
        ArrayList<Team> returnBracket = new ArrayList<>();

        int start = 0;
        int end = (thisRound.size() - 1);

        while (start < end) {
            Team winner = pickWinner(thisRound.get(start), thisRound.get(end));
            returnBracket.add(winner);

            start++;
            end--;
        }
        return returnBracket;
    }
}
