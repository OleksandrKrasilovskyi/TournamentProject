package com.example.tournamentproject.repository;

import com.example.tournamentproject.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // spring data
    List<Team> findAllByTournamentTournamentName(String tournamentName);

    // HQL
    @Query("select team from Team team " +
            "where team.tournament.tournamentName = :tournamentName")
    List<Team> findAllByTournamentTournamentNameWithHQL(@Param("tournamentName") String tournamentName);

    // native sql
    @Query(value = "select * from team " +
            "join tournament tor on tor.tournament_id = team.tournament_id " +
            "where tor.tournament_name = :tournamentName", nativeQuery = true)
    List<Team> findAllByTournamentTournamentNameWithNative(@Param("tournamentName") String tournamentName);

}
