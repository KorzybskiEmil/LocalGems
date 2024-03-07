package com.korzybskiemil.localgems.auth.registration;

import com.korzybskiemil.localgems.auth.validation.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RegistrationErrorHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserTaken(UserAlreadyExistsException e) {return new ErrorResponse(e.getMessage()); }

    public record ErrorResponse (String info) {}
}
