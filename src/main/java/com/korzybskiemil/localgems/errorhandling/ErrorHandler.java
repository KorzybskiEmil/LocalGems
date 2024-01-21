package com.korzybskiemil.localgems.errorhandling;

import com.korzybskiemil.localgems.applicationuser.ApplicationUserNotFoundException;
import com.korzybskiemil.localgems.car.CarNotFoundException;
import com.korzybskiemil.localgems.gamesandconsoles.GamesAndConsolesNotFoundException;
import com.korzybskiemil.localgems.musicandeducation.MusicAndEducationNotFoundException;
import com.korzybskiemil.localgems.realestate.RealEstateNotFoundException;
import com.korzybskiemil.localgems.sports.SportsNotFoundException;
import com.korzybskiemil.localgems.variousservices.VariousServicesNotFoundException;
import com.korzybskiemil.localgems.work.WorkNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({
            CarNotFoundException.class,
            RealEstateNotFoundException.class,
            GamesAndConsolesNotFoundException.class,
            MusicAndEducationNotFoundException.class,
            SportsNotFoundException.class,
            VariousServicesNotFoundException.class,
            WorkNotFoundException.class,
            ApplicationUserNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFound(RuntimeException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(MethodArgumentNotValidException e) {
        String errMsg = e.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(" | "));

        return new ErrorResponse(errMsg);
    }

    public record ErrorResponse(String info) {

    }
}
