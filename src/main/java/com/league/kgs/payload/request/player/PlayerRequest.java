package com.league.kgs.payload.request.player;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.league.kgs.entity.Player;

public class PlayerRequest {

    private final String playerName;

    @JsonCreator
    public PlayerRequest(@JsonProperty("playerName") String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Player asPlayer() {
        return new Player(this.playerName);
    }
}
