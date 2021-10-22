package com.league.kgs.entity;

import javax.persistence.*;

@Entity
public class TeamPlayers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public TeamPlayers() {}

    public TeamPlayers(Player player, Team team) {
        this.player = player;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public Player getUser() {
        return player;
    }

    public void setUser(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
