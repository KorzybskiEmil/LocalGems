package com.korzybskiemil.localgems.applicationuser.dto;

import java.util.UUID;

public record ApplicationUserDto(
        UUID id,
        String username

) {
}
