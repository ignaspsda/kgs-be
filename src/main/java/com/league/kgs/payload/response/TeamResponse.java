package com.league.kgs.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.league.kgs.entity.Team;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamResponse {
    private Long id;
    private String name;
    private List<TournamentResponse> tournamentList;
    private List<PlayerResponse> playersList;

    public TeamResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeamResponse(Long id, String name, List<TournamentResponse> tournamentList, List<PlayerResponse> playersList) {
        this.id = id;
        this.name = name;
        this.tournamentList = tournamentList;
        this.playersList = playersList;
    }

    // For TeamResponse
    public static TeamResponse fromTeam(Team team){
        List<TournamentResponse> tournamentList = team.getTournamentsList().stream().map((tr) -> TournamentResponse.fromTournamentToTeam(tr.getTournament())).collect(Collectors.toList());
        List<PlayerResponse> playersList = team.getPlayersList().stream().map((p) -> PlayerResponse.fromPlayer(p.getUser())).collect(Collectors.toList());
        return new TeamResponse(team.getId(), team.getName(), tournamentList, playersList);
    };

    // For TournamentResponse
    public static TeamResponse fromTeamToTournament(Team team) {
        return new TeamResponse(team.getId(), team.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TournamentResponse> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<TournamentResponse> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public List<PlayerResponse> getPlayersList() {
        return playersList;
    }
}
