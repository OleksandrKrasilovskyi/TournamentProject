package com.example.tournamentproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CSVExportService {

    private final TournamentManagement tournamentManagement;

    public void saveInTXTFile(String tournamentName) {
        var tournamentInTXTFile = tournamentName + ".txt";
        final var tournamentAnotherObjectMap = tournamentManagement.getTournamentSomethingMap();   final var tournamentAnotherObject = tournamentAnotherObjectMap.get(tournamentName);
        final var matchList = tournamentAnotherObject.getListMatch();
        //TODO Реалізувати запис матчів у файл
    }
}
