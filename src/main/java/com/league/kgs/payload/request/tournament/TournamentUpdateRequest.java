package com.league.kgs.payload.request.tournament;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.league.kgs.entity.Tournament;
import com.league.kgs.enums.Mode;

import java.time.LocalDateTime;

public class TournamentUpdateRequest {
    private final Long id;

    private final String title;

    private final Mode mode;

    private final LocalDateTime tournamentStartDate;

    private final int numberOfTeams;

    private final int entryCost;

    @JsonCreator
    public TournamentUpdateRequest(
            @JsonProperty("id") Long id,
            @JsonProperty("title") String title,
            @JsonProperty("mode") Mode mode,
            @JsonProperty("tournamentStartDate") LocalDateTime tournamentStartDate,
            @JsonProperty("numberOfTeams") int numberOfTeams,
            @JsonProperty("entryCost") int entryCost) {
        this.id = id;
        this.title = title;
        this.mode = mode;
        this.tournamentStartDate = tournamentStartDate;
        this.numberOfTeams = numberOfTeams;
        this.entryCost = entryCost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Mode getMode() {
        return mode;
    }

    public LocalDateTime getTournamentStartDate() {
        return tournamentStartDate;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getEntryCost() {
        return entryCost;
    }
}
