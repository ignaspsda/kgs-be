package com.league.kgs.payload.request.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class SignupRequest {

    private final String username;

    private final String email;

    private final String password;

    private final Set<String> role;

    @JsonCreator
    public SignupRequest(@JsonProperty("username") String username, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("role") Set<String> role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRole() {
        return role;
    }
}
