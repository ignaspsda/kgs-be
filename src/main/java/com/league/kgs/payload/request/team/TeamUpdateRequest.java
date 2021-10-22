package com.league.kgs.payload.request.team;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.league.kgs.entity.Team;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TeamUpdateRequest {
    @NotNull(message = "Team ID must be set!")
    private final Long id;

    @NotBlank(message = "Team name must be set!")
    private final String name;

    @JsonCreator
    public TeamUpdateRequest(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TeamUpdateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
