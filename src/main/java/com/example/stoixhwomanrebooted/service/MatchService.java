package com.example.stoixhwomanrebooted.service;

import com.example.stoixhwomanrebooted.dto.MatchDTO;
import com.example.stoixhwomanrebooted.model.Match;
import com.example.stoixhwomanrebooted.repository.MatchRepository;
import com.example.stoixhwomanrebooted.utilities.DTOUtilities;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchService {


    private final DTOUtilities dtoUtilities;
    private final MatchRepository matchRepository;

    public MatchService(DTOUtilities dtoUtilities, MatchRepository matchRepository) {
        this.dtoUtilities = dtoUtilities;
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public List<Match> getAllMatchesByMatchDate(LocalDate date) {

        return matchRepository.getMatchesByMatchDate(date);
    }

    public Match addMatch(MatchDTO matchDTO) {
        Match match = dtoUtilities.transformMatchDTOToMatch(matchDTO);
        return matchRepository.save(match);
    }

    public Match readMatch(Long id) {
        return matchRepository.findById(id).get();
    }

    public Match updateMatch(Long id, MatchDTO matchDTO) {
        Match match = dtoUtilities.transformMatchDTOToMatch(matchDTO);
        match.setId(id);
        return matchRepository.save(match);
    }

    public void deleteMatch(long id) {

        matchRepository.deleteById(id);
    }

}
