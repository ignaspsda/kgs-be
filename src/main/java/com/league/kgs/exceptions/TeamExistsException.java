package com.league.kgs.exceptions;

public class TeamExistsException extends RuntimeException {
    public TeamExistsException(String message) {
        super(message);
    }

    public TeamExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamExistsException(Throwable cause) {
        super(cause);
    }
}
