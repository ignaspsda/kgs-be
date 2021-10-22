package com.league.kgs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Player name must be set!")
    private String playerName;

    @OneToMany(mappedBy = "player")
    private List<TeamPlayers> teamList;

    public Player() {
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<TeamPlayers> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamPlayers> teamList) {
        this.teamList = teamList;
    }
}
