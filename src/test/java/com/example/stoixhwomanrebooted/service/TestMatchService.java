package com.example.stoixhwomanrebooted.service;

import com.example.stoixhwomanrebooted.dto.MatchDTO;
import com.example.stoixhwomanrebooted.model.Match;
import com.example.stoixhwomanrebooted.repository.MatchRepository;
import com.example.stoixhwomanrebooted.utilities.DTOUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestMatchService {


    @InjectMocks
    private MatchService matchService;

    @Mock
    private MatchRepository matchRepository;
    @Mock
    private DTOUtilities dtoUtilities;

    @Test
    public void testGetAllMatches() {
        // Given
        Match match = new Match();
        when(matchRepository.findAll()).thenReturn(List.of(match));

        // When
        List<Match> matches = matchService.getAllMatches();

        // Then
        assertNotNull(matches);
        assertEquals(1, matches.size());
        verify(matchRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllMatchesByMatchDate() {
        // Given
        LocalDate date = LocalDate.now();
        Match match = new Match();
        when(matchRepository.getMatchesByMatchDate(date)).thenReturn(List.of(match));

        // When
        List<Match> matches = matchService.getAllMatchesByMatchDate(date);

        // Then
        assertNotNull(matches);
        assertEquals(1, matches.size());
        verify(matchRepository, times(1)).getMatchesByMatchDate(date);
    }

    @Test
    public void testAddMatch() {
        // Given
        MatchDTO matchDTO = new MatchDTO();
        Match match = new Match();
        when(dtoUtilities.transformMatchDTOToMatch(matchDTO)).thenReturn(match);
        when(matchRepository.save(match)).thenReturn(match);

        // When
        Match result = matchService.addMatch(matchDTO);

        // Then
        assertNotNull(result);
        verify(dtoUtilities, times(1)).transformMatchDTOToMatch(matchDTO);
        verify(matchRepository, times(1)).save(match);
    }

    @Test
    public void testReadMatch() {
        // Given
        Long id = 1L;
        Match match = new Match();
        when(matchRepository.findById(id)).thenReturn(Optional.of(match));

        // When
        Match result = matchService.readMatch(id);

        // Then
        assertNotNull(result);
        verify(matchRepository, times(1)).findById(id);
    }

    @Test
    public void testUpdateMatch() {
        // Given
        Long id = 1L;
        MatchDTO matchDTO = new MatchDTO();
        Match match = new Match();
        when(dtoUtilities.transformMatchDTOToMatch(matchDTO)).thenReturn(match);
        when(matchRepository.save(match)).thenReturn(match);

        // When
        Match result = matchService.updateMatch(id, matchDTO);

        // Then
        assertNotNull(result);
        verify(dtoUtilities, times(1)).transformMatchDTOToMatch(matchDTO);
        verify(matchRepository, times(1)).save(match);
        assertEquals(id, match.getId());
    }

    @Test
    public void testDeleteMatch() {
        // Given
        Long id = 1L;

        // When
        matchService.deleteMatch(id);

        // Then
        verify(matchRepository, times(1)).deleteById(id);
    }
}
