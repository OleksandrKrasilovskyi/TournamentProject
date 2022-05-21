package com.example.TournamentProject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@EntityScan
@AllArgsConstructor
@Getter
@Setter
public class TournamentAnotherObject {
    private List<Team> listTeam;
    private List<Match> listMatch;
}
