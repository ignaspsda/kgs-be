package com.league.kgs.service;

import com.league.kgs.entity.TournamentTeams;
import com.league.kgs.entity.Team;
import com.league.kgs.entity.Tournament;
import com.league.kgs.exceptions.TeamRegisteredException;
import com.league.kgs.repositories.TournamentTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentTeamService {

    private final TournamentTeamRepository tournamentTeamRepository;

    @Autowired
    public TournamentTeamService(TournamentTeamRepository tournamentTeamsRepository) {
        this.tournamentTeamRepository = tournamentTeamsRepository;
    }

    public void addTeamToTournament(Tournament tournament, Team team) {
        if(teamRegisteredForTournament(team, tournament)) {
            throw new TeamRegisteredException(String.format("Team '%s' already registered for this tournament!", team.getName()));
        } else {
            TournamentTeams tournamentTeam = new TournamentTeams(tournament, team);
            this.tournamentTeamRepository.save(tournamentTeam);
        }
    }

    private boolean teamRegisteredForTournament(Team team, Tournament tournament){
        return this.tournamentTeamRepository.ifExists(team, tournament);
    }
}
