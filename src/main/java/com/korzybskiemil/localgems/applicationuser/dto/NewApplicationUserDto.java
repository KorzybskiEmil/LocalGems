package com.korzybskiemil.localgems.applicationuser.dto;

public record NewApplicationUserDto(

        String nickname,
        String email,
        String password
) {
}
