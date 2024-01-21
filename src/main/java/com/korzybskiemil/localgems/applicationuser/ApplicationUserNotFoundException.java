package com.korzybskiemil.localgems.applicationuser;

public class ApplicationUserNotFoundException extends RuntimeException{

    public ApplicationUserNotFoundException(String message) {
        super(message);
    }
}
