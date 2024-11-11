package com.example.stoixhwomanrebooted.controller;


import com.example.stoixhwomanrebooted.dto.MatchDTO;
import com.example.stoixhwomanrebooted.model.Match;
import com.example.stoixhwomanrebooted.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Match", description = "Matches' specific actions")
@RestController
@RequestMapping("/api/v1")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @Operation(summary = "Get all Matches of a specific date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All the Matches returned",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Match.class)))})})
    @GetMapping(value = "/matches/{date}")
    public List<Match> getAllMatchesByDate(@Parameter(description = "The date the matches will be held.")
                                           @PathVariable LocalDate date) {
        return matchService.getAllMatchesByMatchDate(date);
    }

    @Operation(summary = "Add a new Match.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful",
                    content = {@Content}),
            @ApiResponse(responseCode = "400", description = "The operation was not successful",
                    content = {@Content})
    })
    @PostMapping(value = "/match/")
    public ResponseEntity<Match> addMatch(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "A MatchDTO.",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = MatchDTO.class)))
            @RequestBody MatchDTO matchDTO) {
        return ResponseEntity.ok(
                matchService.addMatch(matchDTO));
    }

    @Operation(summary = "Get a specific match according to its id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Match returned",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Match.class))})})
    @GetMapping(value = "/match/{id}")
    public Match readMatch(
            @Parameter(description = "The id of the match.")
            @PathVariable Long id) {
        return matchService.readMatch(id);
    }

    @Operation(summary = "Update a Match.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful",
                    content = {@Content}),
            @ApiResponse(responseCode = "400", description = "The operation was not successful",
                    content = {@Content})
    })
    @PutMapping(value = "/match/{id}")
    public ResponseEntity<Match> updateMatch(
            @Parameter(description = "The id of the match to be updated.")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "A MatchDTO.",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = MatchDTO.class)))
            @RequestBody MatchDTO matchDTO) {
        return ResponseEntity.ok(
                matchService.updateMatch(id, matchDTO));
    }

    @Operation(summary = "Delete a single match")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful",
                    content = {@Content}),
            @ApiResponse(responseCode = "404", description = "The container was not found",
                    content = {@Content})
    })
    @DeleteMapping(value = "/match/{id}")
    public ResponseEntity<?> deleteMatch(@Parameter(description = "The id of the match to be deleted")
                                         @PathVariable long id) {
        try {
            matchService.deleteMatch(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

