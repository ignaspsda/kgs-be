package com.league.kgs.controller;

import com.league.kgs.payload.request.tournament.TournamentCreateRequest;
import com.league.kgs.payload.request.tournament.TournamentUpdateRequest;
import com.league.kgs.payload.response.TournamentResponse;
import com.league.kgs.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TournamentController {
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping("/tournament")
    public void createTournament(@RequestBody @Valid TournamentCreateRequest tournamentCreateRequest) {
        tournamentService.createTournament(tournamentCreateRequest);
    }

    @GetMapping("/tournament/{id}")
    public TournamentResponse getTournament(@PathVariable Long id) {
        return tournamentService.getById(id);
    }

    @GetMapping("/tournament")
    public List<TournamentResponse> getAllTournaments() {
        return tournamentService.getAll();
    }

    @PutMapping("/tournament")
    public void updateTournament(@RequestBody TournamentUpdateRequest tournamentUpdateRequest) {
        tournamentService.updateTournament(tournamentUpdateRequest);
    }

    @DeleteMapping("/tournament/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }
}
