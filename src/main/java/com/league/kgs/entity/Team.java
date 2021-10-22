package com.league.kgs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Team name must be specified!")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<TournamentTeams> tournamentsList;

    @OneToMany(mappedBy = "team")
    private List<TeamPlayers> playersList;

    public Team(){ }

    public Team(String name) {
        this.name = name;
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

    public List<TournamentTeams> getTournamentsList() {
        return tournamentsList;
    }

    public void setTournamentsList(List<TournamentTeams> tournamentsList) {
        this.tournamentsList = tournamentsList;
    }

    public List<TeamPlayers> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<TeamPlayers> playersList) {
        this.playersList = playersList;
    }
}
