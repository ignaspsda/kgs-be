package com.league.kgs.service;

import com.league.kgs.entity.Team;
import com.league.kgs.entity.Tournament;
import com.league.kgs.entity.Player;
import com.league.kgs.exceptions.TeamExistsException;
import com.league.kgs.exceptions.TeamNotFoundException;
import com.league.kgs.exceptions.TournamentNotFoundException;
import com.league.kgs.payload.request.team.TeamCreateRequest;
import com.league.kgs.payload.request.team.TeamUpdateRequest;
import com.league.kgs.payload.response.TeamResponse;
import com.league.kgs.repositories.PlayerRepository;
import com.league.kgs.repositories.TeamRepository;
import com.league.kgs.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TournamentRepository tournamentRepository;
    private final PlayerRepository playerRepository;
    private final TournamentTeamService tournamentTeamService;
    private final TeamPlayersService teamPlayersService;

    @Autowired
    public TeamService(TeamRepository teamRepository, TournamentRepository tournamentRepository, PlayerRepository playerRepository, TournamentTeamService tournamentTeamService, TeamPlayersService teamPlayersService) {
        this.teamRepository = teamRepository;
        this.tournamentRepository = tournamentRepository;
        this.playerRepository = playerRepository;
        this.tournamentTeamService = tournamentTeamService;
        this.teamPlayersService = teamPlayersService;
    }

    public void createTeam(TeamCreateRequest teamCreateRequest) {
        if(teamRepository.ifExists(teamCreateRequest.getName())) {
            throw new TeamExistsException(String.format("Team with name %s already exists!", teamCreateRequest.getName()));
        } else {
            Team team = teamCreateRequest.asTeam();
            teamRepository.save(team);
        }
    }

    public List<TeamResponse> getTeams() {

        return teamRepository.findAll().stream().map(TeamResponse::fromTeam).collect(Collectors.toList());
    }

    public TeamResponse getTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("Team not found!"));
        return TeamResponse.fromTeam(team);
    }

    public void createTeamForTournament(TeamCreateRequest teamCreateRequest, Long tournamentId) {
        if(!teamRepository.ifExists(teamCreateRequest.getName())) {
            Team newTeam = teamCreateRequest.asTeam();
            teamRepository.save(newTeam);

            teamCreateRequest.getPlayers().forEach((player) -> {
                Player newPlayer = player.asPlayer();
                this.playerRepository.save(newPlayer);
                this.teamPlayersService.addPlayerToTeam(newTeam, newPlayer);
            });

            Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new TournamentNotFoundException("Tournament not found!"));
            tournamentTeamService.addTeamToTournament(tournament, newTeam);
        } else {
            throw new TeamExistsException(String.format("Team with name %s already exists!", teamCreateRequest.getName()));
        }
    }

    public void addTeamToTournament(TeamUpdateRequest teamUpdateRequest, Long tournamentId) {
//        Team team = teamRepository.findById(teamUpdateRequest.getId()).orElseThrow(() -> new TeamNotFoundException("Team not found!"));
        Team team = new Team(teamUpdateRequest.getName());
        team.setId(teamUpdateRequest.getId());
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new TournamentNotFoundException("Tournament not found!"));
        tournamentTeamService.addTeamToTournament(tournament, team);
    }

    public void deleteTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new TeamNotFoundException("Team not found!"));
        teamRepository.delete(team);
    }

    public void updateTeam(TeamUpdateRequest teamUpdateRequest) {
        Team team = teamRepository.findById(teamUpdateRequest.getId()).orElseThrow(() -> new TeamNotFoundException("Team not found!"));
        team.setName(teamUpdateRequest.getName());
        teamRepository.save(team);
    }
}
