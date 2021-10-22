package com.league.kgs.payload.request.team;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.league.kgs.entity.Team;
import com.league.kgs.payload.request.player.PlayerRequest;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TeamCreateRequest {

    @NotBlank(message = "Team name must be set!")
    private final String name;

    private final List<PlayerRequest> playersList;

    @JsonCreator
    public TeamCreateRequest(@JsonProperty("name") String name, @JsonProperty("players") List<PlayerRequest> playersList) {
        this.name = name;
        this.playersList = playersList;
    }

    public Team asTeam() {
        return new Team(this.name);
    }

    public String getName() {
        return name;
    }

    public List<PlayerRequest> getPlayers() {
        return playersList;
    }
}
