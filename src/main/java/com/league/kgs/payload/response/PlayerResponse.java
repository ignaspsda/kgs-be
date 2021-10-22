package com.league.kgs.payload.response;

import com.league.kgs.entity.Player;

public class PlayerResponse {

    private final String playerName;

    public PlayerResponse(String playerName) {
        this.playerName = playerName;
    }

    public static PlayerResponse fromPlayer(Player player) {
        return new PlayerResponse(player.getPlayerName());
    }

    public String getPlayerName() {
        return playerName;
    }
}
