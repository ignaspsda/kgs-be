package com.league.kgs.entity;

import com.league.kgs.enums.Mode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tournament title must be set!")
    private String title;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tournament mode must be set!")
    private Mode mode;

    private LocalDateTime tournamentStartDate;

    @NotNull(message = "Number of teams must be set!")
    private int numberOfTeams;

    private int entryCost;

    @OneToMany(mappedBy = "tournament")
    private List<TournamentTeams> teamsList;

    public Tournament() {
    }

    public Tournament(String title, Mode mode, LocalDateTime tournamentStartDate, int numberOfTeams, int entryCost) {
        this.title = title;
        this.mode = mode;
        this.tournamentStartDate = tournamentStartDate;
        this.numberOfTeams = numberOfTeams;
        this.entryCost = entryCost;
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

    public List<TournamentTeams> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<TournamentTeams> teamsList) {
        this.teamsList = teamsList;
    }
}
