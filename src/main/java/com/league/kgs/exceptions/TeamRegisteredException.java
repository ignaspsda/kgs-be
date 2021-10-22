package com.league.kgs.exceptions;

public class TeamRegisteredException extends RuntimeException {
    public TeamRegisteredException(String message) {
        super(message);
    }

    public TeamRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamRegisteredException(Throwable cause) {
        super(cause);
    }
}
