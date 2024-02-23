package com.korzybskiemil.localgems.auth;

public record JwtTokenRequest(
        String username,
        String password
) {
}
