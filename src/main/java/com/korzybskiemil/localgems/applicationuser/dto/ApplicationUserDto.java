package com.korzybskiemil.localgems.applicationuser.dto;

import java.util.UUID;

public record ApplicationUserDto(
        UUID id,
        String nickname,
        String email,
        String password
) {
}
