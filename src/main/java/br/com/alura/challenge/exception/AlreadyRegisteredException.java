package br.com.alura.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyRegisteredException extends RuntimeException {

    public AlreadyRegisteredException(String exception) {
        super(exception);
    }
}