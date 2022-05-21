package com.example.TournamentProject;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class TeamManagement {

    public List<String> createTeamName(List<String> teams) {

        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            while (!buffer.readLine().equalsIgnoreCase("finish")) {
                for (int i = 1; i > 0; i++) {
                    teams.add(buffer.readLine());
                    if (teams.size() < 4) {
                        System.out.println("Введите минимум 4 команды!");
                    }
                }
                do {
                    for (int j = 2; j < teams.size(); j *= 2) {
                        if (teams.size() != Math.pow(2, j)) {
                            System.out.println("Введите больше команд");
                        }
                    }
                } while (true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }
}
