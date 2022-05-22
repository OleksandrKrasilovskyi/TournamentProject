package com.example.TournamentProject;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

@Service
public class TeamManagement {

    public void createTeam(List<Team> teams) {
        System.out.println("Enter at least 4 teams:");
        String stop = "stop";
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            while (!(buffer.readLine().equalsIgnoreCase(stop))) {
                teams.add(new Team(buffer.readLine(), buffer.readLine(), buffer.readLine()));
//               for (int j = 2; j < teams.size(); j *= 2) {
//                   if (teams.size() != Math.pow(2, j)) {
//                       System.out.println("Insufficient number of teams to draw the tournament bracket");
//                   }else if (teams.size() < 4) {
//                       System.out.println("Enter at least 4 teams");
//                   }
//               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(teams);
    }
}
