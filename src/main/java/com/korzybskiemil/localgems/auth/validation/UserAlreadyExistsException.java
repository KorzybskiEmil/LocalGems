package com.korzybskiemil.localgems.auth.validation;

public class UserAlreadyExistsException extends Throwable {
        public UserAlreadyExistsException(String username) {
            super("User " + username + " already exists");
        }
    }

