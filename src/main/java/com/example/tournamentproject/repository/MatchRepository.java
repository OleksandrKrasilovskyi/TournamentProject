package com.example.tournamentproject.repository;

import com.example.tournamentproject.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
