package com.example.tournamentproject.service;

import com.example.tournamentproject.entity.Match;
import com.example.tournamentproject.entity.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamManagement {
    private TournamentManagement tournamentManagement;

    public void createTeam(String teamName, String coachName, String capitanName, String tournamentName) {
        Team team = new Team(teamName, capitanName, coachName);
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();//Возвращаем маппу с другого класса , новый обьект что бы с ним тут работать
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);//Получаем обьекты по ключу что бы я мог работать со значением по tournamentName
        tournamentAnotherObject.getListTeam().add(team); //Получаем лист команд и в него добавляем команду
        }

    public void createMatch(String round, String team1, String team2,String score, String tournamentName) {
        Match match = new Match(round, team1, team2,score);
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentAnotherObjectMap();
        final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        tournamentAnotherObject.getListMatch().add(match);
    }
}
