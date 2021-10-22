package com.league.kgs.exceptions;

public class TournamentNotFoundException extends RuntimeException {

    public TournamentNotFoundException(String message) {
        super(message);
    }

    public TournamentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TournamentNotFoundException(Throwable cause) {
        super(cause);
    }
}
