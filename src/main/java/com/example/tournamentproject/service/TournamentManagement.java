package com.example.tournamentproject.service;

import com.example.tournamentproject.dto.TournamentAnotherObject;
import com.example.tournamentproject.entity.Match;
import com.example.tournamentproject.entity.Team;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TournamentManagement {
    @Getter
    private final Map<String, TournamentAnotherObject> tournamentAnotherObjectMap = new HashMap<>();

    public void createTournamentAnotherObjectMap(String tournamentName) {
        tournamentAnotherObjectMap.put(tournamentName, new TournamentAnotherObject());
    }
}