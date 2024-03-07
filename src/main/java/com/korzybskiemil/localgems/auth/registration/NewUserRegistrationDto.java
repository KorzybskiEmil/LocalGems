package com.korzybskiemil.localgems.auth.registration;

public record NewUserRegistrationDto(
        String username,
        String password
) {
}
