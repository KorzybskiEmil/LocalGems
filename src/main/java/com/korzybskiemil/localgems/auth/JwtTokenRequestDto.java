package com.korzybskiemil.localgems.auth;

public record JwtTokenRequestDto(
        String username,
        String password
) {
}
