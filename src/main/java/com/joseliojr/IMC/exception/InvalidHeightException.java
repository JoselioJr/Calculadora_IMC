package com.joseliojr.IMC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidHeightException extends RuntimeException {
    public InvalidHeightException(String message) {
        super(message);
    }
}
