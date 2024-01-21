package com.korzybskiemil.localgems.sports;

public class SportsNotFoundException extends RuntimeException{

    public SportsNotFoundException(String message) {
        super(message);
    }
}