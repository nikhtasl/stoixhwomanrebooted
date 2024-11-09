package com.example.stoixhwomanrebooted.dto;

import com.example.stoixhwomanrebooted.enums.Sport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MatchDTO {

    private LocalDate matchDate;
    private LocalTime matchTime;
    private String teamA;
    private String teamB;
    private Sport sport;
    private List<MatchOddsDTO> matchOddsDTOs;

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String team_a) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public List<MatchOddsDTO> getMatchOddsDTOs() {
        return matchOddsDTOs;
    }

    public void setMatchOddsDTOs(List<MatchOddsDTO> matchOddsDTOs) {
        this.matchOddsDTOs = matchOddsDTOs;
    }
}
