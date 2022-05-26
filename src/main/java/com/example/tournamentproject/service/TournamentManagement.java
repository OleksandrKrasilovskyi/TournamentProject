package com.example.tournamentproject.service;

import com.example.tournamentproject.dto.TournamentSomething;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TournamentManagement {
    @Getter
    private final Map<String, TournamentSomething> tournamentSomethingMap = new HashMap<>();

    public void createOurMap(String tournamentName) {
        tournamentSomethingMap.put(tournamentName, new TournamentSomething());
    }

}
