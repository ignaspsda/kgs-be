package com.league.kgs.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.league.kgs.entity.Tournament;
import com.league.kgs.enums.Mode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TournamentResponse {
    private Long id;

    private String title;

    private Mode mode;

    private LocalDateTime tournamentStartDate;

    private int numberOfTeams;

    private int entryCost;

    private List<TeamResponse> teamList;

    public TournamentResponse(Long id, String title, Mode mode, LocalDateTime tournamentStartDate, int numberOfTeams, int entryCost) {
        this.id = id;
        this.title = title;
        this.mode = mode;
        this.tournamentStartDate = tournamentStartDate;
        this.numberOfTeams = numberOfTeams;
        this.entryCost = entryCost;
    }

    public TournamentResponse(Long id, String title, Mode mode, LocalDateTime tournamentStartDate, int numberOfTeams, int entryCost, List<TeamResponse> teamList) {
        this.id = id;
        this.title = title;
        this.mode = mode;
        this.tournamentStartDate = tournamentStartDate;
        this.numberOfTeams = numberOfTeams;
        this.entryCost = entryCost;
        this.teamList = teamList;
    }

    // For TeamResponse
    public static TournamentResponse fromTournament(Tournament tournament) {
        List<TeamResponse> teamList = tournament.getTeamsList().stream().map((t) -> TeamResponse.fromTeamToTournament(t.getTeam())).collect(Collectors.toList());
        return new TournamentResponse(
                tournament.getId(),
                tournament.getTitle(),
                tournament.getMode(),
                tournament.getTournamentStartDate(),
                tournament.getNumberOfTeams(),
                tournament.getEntryCost(),
                teamList
        );
    }

    // For TournamentResponse
    public static TournamentResponse fromTournamentToTeam(Tournament tournament){
        return new TournamentResponse(
                tournament.getId(),
                tournament.getTitle(),
                tournament.getMode(),
                tournament.getTournamentStartDate(),
                tournament.getNumberOfTeams(),
                tournament.getEntryCost()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public LocalDateTime getTournamentStartDate() {
        return tournamentStartDate;
    }

    public void setTournamentStartDate(LocalDateTime tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public int getEntryCost() {
        return entryCost;
    }

    public void setEntryCost(int entryCost) {
        this.entryCost = entryCost;
    }

    public List<TeamResponse> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamResponse> teamList) {
        this.teamList = teamList;
    }
}
