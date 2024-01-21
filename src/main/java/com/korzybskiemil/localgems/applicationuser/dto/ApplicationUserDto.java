package com.korzybskiemil.localgems.applicationuser.dto;

import java.util.UUID;

public record ApplicationUserDto(
        UUID id,
        String firstName,
        String lastName,
        String nickname,
        String email
) {
}
