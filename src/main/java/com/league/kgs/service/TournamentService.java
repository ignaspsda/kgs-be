package com.league.kgs.service;

import com.league.kgs.entity.Tournament;
import com.league.kgs.exceptions.TournamentNotFoundException;
import com.league.kgs.payload.request.tournament.TournamentCreateRequest;
import com.league.kgs.payload.request.tournament.TournamentUpdateRequest;
import com.league.kgs.payload.response.TournamentResponse;
import com.league.kgs.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<TournamentResponse> getAll() {
        return tournamentRepository.findAll().stream().map(TournamentResponse::fromTournament).collect(Collectors.toList());
    }

    @Transactional
    public void createTournament(TournamentCreateRequest tournamentCreateRequest) {
        Tournament tournament = tournamentCreateRequest.asTournament();
        tournamentRepository.save(tournament);
    }

    public TournamentResponse getById(Long id)  {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new TournamentNotFoundException("Tournament not found!"));
        return TournamentResponse.fromTournament(tournament);
    }

    public void updateTournament(TournamentUpdateRequest tournamentUpdateRequest) {
        Tournament tournament = tournamentRepository.findById(tournamentUpdateRequest.getId()).orElseThrow(
                () -> new TournamentNotFoundException("Tournament not found!")
        );
        tournament.setTitle(tournamentUpdateRequest.getTitle());
        tournament.setMode(tournamentUpdateRequest.getMode());
        tournament.setTournamentStartDate(tournamentUpdateRequest.getTournamentStartDate());
        tournament.setNumberOfTeams(tournamentUpdateRequest.getNumberOfTeams());
        tournament.setEntryCost(tournamentUpdateRequest.getEntryCost());

        tournamentRepository.save(tournament);
    }

    @Transactional
    public void deleteTournament(Long id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new TournamentNotFoundException("Tournament not found!"));
        tournamentRepository.delete(tournament);
    }

}
