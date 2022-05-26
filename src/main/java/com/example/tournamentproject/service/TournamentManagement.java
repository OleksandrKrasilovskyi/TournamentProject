package com.example.tournamentproject.service;

import com.example.tournamentproject.dto.TournamentAnotherObject;
import com.example.tournamentproject.entity.Match;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TournamentManagement {
    @Getter
    private final Map<String, TournamentAnotherObject> tournamentAnotherObjectMap = new HashMap<>();

    public void createTournamentAnotherObjectMap(String tournamentName) {
        tournamentAnotherObjectMap.put(tournamentName, new TournamentAnotherObject());
    }

    public void createMatch(String round, String team1, String team2, String score, String tournamentName) {
        Match match = new Match(round, team1, team2, score);
        final var tournamentAnotherObjectMap = getTournamentAnotherObjectMap();
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        tournamentAnotherObject.getListMatch().add(match);
    }

//    public Team pickWinner(Team home, Team guest) throws IOException {
//
//        int homeInt = 0;
//        int guestInt = 0;
//        String homeString;
//        String guestString;
//        List<Team> nextRoundList = new ArrayList<>();
//
//        List<Team> thisGame = new ArrayList<>();
//        thisGame.add(home);
//        thisGame.add(guest);
//
//        homeString = buffer.readLine();
//        homeInt = Integer.parseInt(homeString);
//        guestString = buffer.readLine();
//        guestInt = Integer.parseInt(guestString);
//
//        if (homeInt > guestInt) {
//            nextRoundList.add(home);
//        } else {
//            nextRoundList.add(guest);
//        }
//
//        System.out.println("Result: " + home.toString() + ", " + guest.toString() + ", " + homeInt + ", " + guestInt);
//        return nextRoundList.get(0);
//    }
//
//    public List<Team> processBracket(List<Team> teamList) throws IOException {
//        List<Team> returnBracket = new ArrayList<>();
//
//        int start = 0;
//        int end = (teamList.size() - 1);
//
//        while (start < end) {
//            Team winner = pickWinner(teamList.get(start), teamList.get(end));
//            returnBracket.add(winner);
//
//            start++;
//            end--;
//        }
//        return returnBracket;
//    }
}
