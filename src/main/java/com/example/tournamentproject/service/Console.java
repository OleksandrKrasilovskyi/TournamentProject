package com.example.tournamentproject.service;

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
        System.out.println("Вітаю в Tournament Bracket!");
        final var tournamentName = createTournamentName();
        tournamentManagement.createOurMap(tournamentName);
        final var teamList = createTeamsData(tournamentName);
        Collections.shuffle(teamList);
        buildMatchesForSpecificTournament(teamList, tournamentName);
        printUpComingMatchesForSpecificTournament(tournamentName);

        //TODO Вивести юзеру всі можливі наступні варіанти
        System.out.println("");
    }

    public String createTournamentName() throws IOException {
        System.out.println("Введіть назву турнірної сітки :)");
        return buffer.readLine();
    }


    public List<Team> createTeamsData(String tournamentName) throws IOException {

        final var tournamentSomethingMap = tournamentManagement.getTournamentSomethingMap();
        final var something = tournamentSomethingMap.get(tournamentName);
        int numberTeams = 0;
        while (!acceptableTeamNumber(numberTeams) || numberTeams == 1) {
            System.out.println("Введіть кількість команд :) Наприклад: 4, 8, 16, ..., n².");
            numberTeams = Integer.parseInt(buffer.readLine());
        }
        System.out.println("В турнірі бере участь така кількість команд: " + numberTeams);

        for (int i = 1; i <= numberTeams; i++) {
            System.out.println("Введіть назву команди, її капітана та тренера :)");
            String teamName = buffer.readLine();
            String capitanName = buffer.readLine();
            String coachName = buffer.readLine();
            teamManagement.createTeam(teamName, capitanName, coachName, tournamentName);
            System.out.println("Команду додано :)");
            System.out.println("Команду додано :)");
        }
        return something.getListTeam();
    }

    public boolean acceptableTeamNumber(int teamSizeCounter) {
        for (int i = 2; i < 5000; i++) {
            if (Math.pow(2, i) == teamSizeCounter) {
                return true;
            }
        }
        return false;
    }

    private void buildMatchesForSpecificTournament(List<Team> teamList, String tournamentName) {
        //TODO Придумати логіку, яка буде створювати матчі
    }

    private void printUpComingMatchesForSpecificTournament(String tournamentName) throws IOException {
        //TODO Дає можливість подивитися "предстоящие" матчі
        final var tournamentSomethingMap = tournamentManagement.getTournamentSomethingMap();
        final var something = tournamentSomethingMap.get(tournamentName);
        System.out.println("Для перегляду сітки наступних матчів введіть 'show'");
        final var view = buffer.readLine().equalsIgnoreCase("show");
        if (view) {
            for (int i = 0; i < something.getListMatch().size(); i++) {
                System.out.println(something.getListMatch().get(i) + "\n");
            }
        }
    }

    private void playTournament(String tournamentName) {

    }

//    public void acceptableTeamNumber(int x) {
//        System.out.println("Введіть кількість команд :) В кінці напишіть 'Готово'");
//        for (int i = 0; i <= 4; i++) {
//            if (x != Math.pow(2, i)) {
//                System.out.println("Кількість команд має бути 4, 8, 16, ..., n².");
//            } else if (x < 4) {
//                System.out.println("Будь ласка, введіть не менше ніж 4 команди");
//            }
//        }
//    }

//    private void validateTeamSize(TournamentSomething tournamentSomething) {
//        //TODO Переписати валідацію (працює некоректно, поправити)
//        for (int j = 0; j < tournamentSomething.getListTeam().size(); j++) {
//            if (tournamentSomething.getListTeam().size() != Math.pow(2, j)) {
//                System.out.println("Кількість команд має бути 4, 8, 16, ..., n².");
//            } else if (tournamentSomething.getListTeam().size() < 4) {
//            System.out.println("Будь ласка, введіть не менше ніж 4 команди");
//        }
//    }
}



