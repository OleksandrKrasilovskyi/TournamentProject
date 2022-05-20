package com.example.TournamentProject;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@Component
public class Game {

    public static int max_number_teams = 32;

    public void createTournament() {

        List<String> arrayList = new ArrayList<>();

        String team1;
        String team2;
        String teamName;
        int numTeams = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("UEFA Champions Leageu");

        while (!acceptableTramNumber(numTeams) || numTeams == 1){
            System.out.println("Enter the number of teams (2, 4, 8, 16, 32): ");
            numTeams = scanner.nextInt();
        }


        System.out.println("\nEnter " + numTeams + " teamName");
        System.out.println("Teams may be entered in any order ");

        for (int i = 1; i <= numTeams; i++){
            System.out.println("\nEnter team name: ");
            teamName = scanner.nextLine();
            arrayList.add(teamName);
        }

        Collections.shuffle(arrayList);
        System.out.println("\nThe first round matchups are: ");

        for (int i = 1; i<=(numTeams/2); i++){
            team1 = (arrayList.get(0));
            arrayList.remove(0);
            team2 = (arrayList.get(0));
            arrayList.remove(0);
            System.out.println(team1 + " vs " + team2);
//            System.out.println("with the winner to play the winner of game " + (((numTeams/2) + 1) - i) + "\n");
        }
    }

    public static boolean acceptableTramNumber(int x){
        for (int i = 0; i < 12; i++){
            if (Math.pow(2, i) == x && x < max_number_teams)
                return true;
        }
        return false;
    }

}

