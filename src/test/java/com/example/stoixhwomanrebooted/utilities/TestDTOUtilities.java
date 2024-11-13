package com.example.stoixhwomanrebooted.utilities;

import com.example.stoixhwomanrebooted.dto.MatchDTO;
import com.example.stoixhwomanrebooted.dto.MatchOddsDTO;
import com.example.stoixhwomanrebooted.enums.Sport;
import com.example.stoixhwomanrebooted.model.Match;
import com.example.stoixhwomanrebooted.model.MatchOdds;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class TestDTOUtilities {


    @Test
    public void testTransformMatchDTOToMatch() {
        DTOUtilities dtoUtilities = new DTOUtilities();

        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setTeamA("OSFP");
        matchDTO.setTeamB("PAOK");
        matchDTO.setMatchDate(LocalDate.of(2023, Month.NOVEMBER, 30));
        matchDTO.setMatchTime(LocalTime.of(22, 00, 00));
        matchDTO.setSport(Sport.FOOTBALL);
        MatchOddsDTO matchOddsDTO1 = new MatchOddsDTO();
        matchOddsDTO1.setOdd(1.2);
        matchOddsDTO1.setSpecifier('1');
        MatchOddsDTO matchOddsDTO2 = new MatchOddsDTO();
        matchOddsDTO2.setOdd(9);
        matchOddsDTO2.setSpecifier('2');
        MatchOddsDTO matchOddsDTO3 = new MatchOddsDTO();
        matchOddsDTO3.setOdd(5);
        matchOddsDTO3.setSpecifier('X');
        List<MatchOddsDTO> matchOddsDTOs = Arrays.asList(matchOddsDTO1, matchOddsDTO2, matchOddsDTO3);
        matchDTO.setMatchOddsDTOs(matchOddsDTOs);

        Match result = dtoUtilities.transformMatchDTOToMatch(matchDTO);

        Assert.assertEquals("OSFP", result.getTeamA());
        Assert.assertEquals("PAOK", result.getTeamB());
        Assert.assertEquals("OSFP-PAOK", result.getDescription());
        Assert.assertEquals(LocalDate.of(2023, Month.NOVEMBER, 30), result.getMatchDate());
        Assert.assertEquals(LocalTime.of(22, 00, 00), result.getMatchTime());
        Assert.assertEquals(Sport.FOOTBALL, result.getSport());
        Assert.assertEquals(3, result.getMatchOdds().size());
    }

    @Test
    public void testTransformMatchOddsDTOToMatchOdds() {
        DTOUtilities dtoUtilities = new DTOUtilities();

        MatchOddsDTO matchOddsDTO = new MatchOddsDTO();
        matchOddsDTO.setOdd(1.2);
        matchOddsDTO.setSpecifier('1');

        MatchOdds result = dtoUtilities.transformMatchOddsDTOToMatchOdds(matchOddsDTO);

        Assert.assertEquals(1.2, result.getOdd(), 0.01);
        Assert.assertEquals('1', result.getSpecifier());
    }
}
