package com.league.kgs.controller;

import com.league.kgs.payload.request.team.TeamCreateRequest;
import com.league.kgs.payload.request.team.TeamUpdateRequest;
import com.league.kgs.payload.response.TeamResponse;
import com.league.kgs.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team")
    public void createTeam(@RequestBody @Valid TeamCreateRequest teamCreateRequest) {
        teamService.createTeam(teamCreateRequest);
    }

    @PostMapping("/team/{id}")
    public void createTeamForTournament(@RequestBody @Valid TeamCreateRequest teamCreateRequest, @PathVariable Long id) {
        teamService.createTeamForTournament(teamCreateRequest, id);
    }

    @GetMapping("/team")
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/team/{id}")
    public TeamResponse getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @PutMapping("/team/{tournamentId}")
    public void addTeamToTournament(@RequestBody @Valid TeamUpdateRequest teamUpdateRequest, @PathVariable Long tournamentId) {
        System.out.println("Team which will be added: " + teamUpdateRequest + "\nTournament ID: " + tournamentId);
        teamService.addTeamToTournament(teamUpdateRequest, tournamentId);
    }

    @DeleteMapping("/team/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

    @PutMapping("/team")
    public void updateTeam(@RequestBody TeamUpdateRequest teamUpdateRequest) {
        teamService.updateTeam(teamUpdateRequest);
    }
}
