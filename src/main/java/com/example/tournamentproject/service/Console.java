package com.example.tournamentproject.service;

import com.example.tournamentproject.dto.TournamentAnotherObject;
import com.example.tournamentproject.entity.Match;
import com.example.tournamentproject.entity.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Service
@AllArgsConstructor
public class Console {

    private TeamManagement teamManagement;
    private TournamentManagement tournamentManagement;
    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


    public void startApp() throws IOException {
        System.out.println("Добро пожаловать в  Bracket Tournament");
        System.out.println("------------------------------");
        System.out.println("Введите имя турнира: ");
        final var tournamentName = createTournamentName();
        System.out.println("Турнир " + tournamentName + " удачно создан");
        tournamentManagement.createTournamentAnotherObjectMap(tournamentName);
        final var teamList = createTeamsData(tournamentName);
        final var matchList =  buildMatchesForSpecificTournament(teamList, tournamentName);
        printUpComingMatchesForSpecificTournament(tournamentName);

        //TODO Вивести юзеру всі можливі наступні варіанти
        System.out.println("");
    }

    private List<Match> buildMatchesForSpecificTournament(List<Team> teamList, String tournamentName) {
        //TODO Придумати логіку, яка буде створювати матчі
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        Collections.shuffle(teamList);
        for (int i = 0; i < teamList.size() /2; i++) {
            teamManagement.createMatch("Round 1/" + (teamList.size() / 2), teamList.get(i + i).getTeamName(), teamList.get(i + (i + 1)).getTeamName(),"0:0", tournamentName);
        }
        return tournamentAnotherObject.getListMatch();
    }

   private void printUpComingMatchesForSpecificTournament(String tournamentName) throws IOException {
        //TODO Дає можливість подивитися "предстоящие" матчі
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        System.out.println("Для просмотря сетки матчей напиши 'show'");
        final var view = buffer.readLine().equalsIgnoreCase("show");
        if (view) {
            for (int i = 0; i < tournamentAnotherObject.getListMatch().size(); i++) {
               System.out.println(tournamentAnotherObject.getListMatch().get(i) + "\n");
            }
        }
    }

    private void playTournament(String tournamentName)  {
    }

    public String createTournamentName() throws IOException {
        return buffer.readLine();
    }

    public List<Team> createTeamsData(String tournamentName) throws IOException {
        int numTeams = 0;
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        while (!acceptTableTeamNumber(numTeams) || numTeams == 1) {
            System.out.println("Введите количество команд участвующих в турнире: 4, 8, 16, ..., n²."); //Запрашивает команды пока их не будет правильное количество
            numTeams = Integer.parseInt(buffer.readLine());
        }
        System.out.println("В турнире учавствует  " + numTeams + " команды");
        for (int i = 1; i <= numTeams; i++) {
            System.out.println("Введите название команды,тренера и капитана");
            teamManagement.createTeam(buffer.readLine(), buffer.readLine(), buffer.readLine(), tournamentName);
            System.out.println("Команда создана");
        }
        return tournamentAnotherObject.getListTeam();
    }

    public static boolean acceptTableTeamNumber(int x) {
        for (int i = 2; i < 12; i++) {
            if (Math.pow(2, i) == x)
                return true;
        }
        return false;
    }
}



