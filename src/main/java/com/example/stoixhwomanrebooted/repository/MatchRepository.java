package com.example.stoixhwomanrebooted.repository;

import com.example.stoixhwomanrebooted.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> getMatchesByMatchDate(LocalDate match_date);
}
