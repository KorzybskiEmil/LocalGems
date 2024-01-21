package com.korzybskiemil.localgems.applicationuser.dto;

public record NewApplicationUserDto(
        String firstName,
        String lastName,
        String nickname,
        String email
) {
}
