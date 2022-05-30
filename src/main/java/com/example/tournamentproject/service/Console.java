package com.example.tournamentproject.service;

import com.example.tournamentproject.entity.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Console {

    private final TeamManagement teamManagement;
    private final TournamentManagement tournamentManagement;
    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public void startApp() throws IOException {
        System.out.println("Welcome to Bracket Tournament");
        System.out.println("------------------------------");
        System.out.println("Enter tournament name: ");
        final var tournamentName = getTournamentName();
        tournamentManagement.createTournament(tournamentName);
        final var teamList = createTeamsData(tournamentName);
//        final var matchList = buildMatchesForSpecificTournament(teamList, tournamentName);
//        printUpComingMatchesForSpecificTournament(tournamentName);
//        //TODO Вивести юзеру всі можливі наступні варіанти
//        final var newRoundListTeams = chooseMatchAndPickWinner(matchList);
//        final var playNextRoundListMatches = playNextRound(newRoundListTeams, tournamentName);
    }

    public String getTournamentName() throws IOException {
        return buffer.readLine();
    }

    public List<Team> createTeamsData(String tournamentName) throws IOException {
        int numTeams = 0;
        while (!validateTeamSize(numTeams) || numTeams == 1) {
            System.out.println("Enter set teams (4, 8, 16, 32, 64, etc)");
            numTeams = Integer.parseInt(buffer.readLine());
        }
        System.out.println("Tournament have " + numTeams + " teams");
        for (int i = 1; i <= numTeams; i++) {
            System.out.println("Enter teamName, coachName and capitanName of " + i + " team");
            teamManagement.createTeam(buffer.readLine(), buffer.readLine(), buffer.readLine(), tournamentName);
            System.out.println("Team " + i + " is complete");
        }
        return teamManagement.findAllTeamsByTournamentName(tournamentName);
    }

//
//    private List<Match> buildMatchesForSpecificTournament(List<Team> teamList, String tournamentName) throws IOException {
//        //TODO Придумати логіку, яка буде створювати матчі
//        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
//        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
//        Collections.shuffle(teamList);
//        for (int i = 0; i < teamList.size() / 2; i++) {
//            tournamentManagement.createMatch("Round 1/" + (teamList.size() / 2), teamList.get(i + i).getTeamName(), teamList.get(i + (i + 1)).getTeamName(), null, tournamentName);
//        }
//        return tournamentAnotherObject.getListMatch();
//    }
//
//    public List<String> chooseMatchAndPickWinner(List<Match> matchList) throws IOException {
//        System.out.println("Choose the match would you like to play (the countdown starts at 0)");
//        List<String> nextRoundListOfMatches = new ArrayList<>();
//        for (int i = 0; i < matchList.size(); i++) {
//            if (buffer.readLine().equalsIgnoreCase(String.format("%d", i))) {
//                System.out.println("Enter team name winner");
//            }
//            if (buffer.readLine().equalsIgnoreCase(matchList.get(i).getFirstTeam())) {
//                nextRoundListOfMatches.add(matchList.get(i).getFirstTeam());
//            } else nextRoundListOfMatches.add(matchList.get(i).getSecondTeam());
//        }
//        return nextRoundListOfMatches;
//    }
//
//    public List<Match> playNextRound(List<String> nextRoundListOfMatches, String tournamentName) {
//        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
//        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
//        Collections.shuffle(nextRoundListOfMatches);
//        for (int i = 0; i < nextRoundListOfMatches.size() / 2; i++) {
//            tournamentManagement.createMatch("Round 1/" + nextRoundListOfMatches.size() / 2, nextRoundListOfMatches.get(i + i),
//                    nextRoundListOfMatches.get(i + (i + 1)), null, tournamentName);
//        }
//        return tournamentAnotherObject.getListMatch();
//    }
//
//    private void printUpComingMatchesForSpecificTournament(String tournamentName) throws IOException {
//        //TODO Дає можливість подивитися "предстоящие" матчі
//        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
//        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
//        System.out.println("If you want view upcoming matches print 'show'");
//        final var view = buffer.readLine().equalsIgnoreCase("show");
//        if (view) {
//            for (int i = 0; i < tournamentAnotherObject.getListMatch().size(); i++) {
//                System.out.println(tournamentAnotherObject.getListMatch().get(i) + "\n");
//            }
//        }
//    }
//
//    private void playTournament(String tournamentName) throws IOException {
//
//    }
//

//
    private boolean validateTeamSize(int numTeams) {
        //TODO Переписати валідацію (працює некоректно, поправити)
        for (int j = 2; j < (Integer.MAX_VALUE / 1000); j++) {
            if (Math.pow(2, j) == numTeams) {
                return true;
            }
        }
        return false;
    }
}
