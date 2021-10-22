package com.league.kgs.exceptions.handler;

import com.league.kgs.exceptions.response.ErrorResponse;
import com.league.kgs.exceptions.TournamentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TournamentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(TournamentNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
