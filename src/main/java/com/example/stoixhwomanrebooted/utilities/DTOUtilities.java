package com.example.stoixhwomanrebooted.utilities;

import com.example.stoixhwomanrebooted.dto.MatchDTO;
import com.example.stoixhwomanrebooted.dto.MatchOddsDTO;
import com.example.stoixhwomanrebooted.model.Match;
import com.example.stoixhwomanrebooted.model.MatchOdds;

import java.util.ArrayList;
import java.util.List;

public class DTOUtilities {
    public Match transformMatchDTOToMatch(MatchDTO matchDTO) {
        Match match = new Match();
        match.setDescription(matchDTO.getTeamA() + "-" + matchDTO.getTeamB());
        match.setMatchDate(matchDTO.getMatchDate());
        match.setMatchTime(matchDTO.getMatchTime());
        match.setTeamA(matchDTO.getTeamA());
        match.setTeamB(matchDTO.getTeamB());
        match.setSport(matchDTO.getSport());
        List<MatchOdds> matchOddsList = new ArrayList<>();
        for (MatchOddsDTO matchOddDTO : matchDTO.getMatchOddsDTOs()) {
            matchOddsList.add(transformMatchOddsDTOToMatchOdds(matchOddDTO));
        }
        match.setMatchOdds(matchOddsList);
        return match;
    }

    public MatchOdds transformMatchOddsDTOToMatchOdds(MatchOddsDTO matchOddsDTO) {
        MatchOdds matchOdds = new MatchOdds();
        matchOdds.setSpecifier(matchOddsDTO.getSpecifier());
        matchOdds.setOdd(matchOddsDTO.getOdd());
        return matchOdds;
    }
}
