package com.example.stoixhwomanrebooted.dto;

import com.example.stoixhwomanrebooted.enums.Sport;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MatchDTO {

    private LocalDate matchDate;
    @JsonFormat(pattern = "HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Schema(type = "string", pattern = "HH:mm:ss", example = "12:00:00")
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

    public void setTeamA(String teamA) {
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
