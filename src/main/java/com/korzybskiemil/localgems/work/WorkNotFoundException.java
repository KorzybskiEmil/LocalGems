package com.korzybskiemil.localgems.work;

public class WorkNotFoundException extends RuntimeException{

    public WorkNotFoundException(String message) {
        super(message);
    }
}