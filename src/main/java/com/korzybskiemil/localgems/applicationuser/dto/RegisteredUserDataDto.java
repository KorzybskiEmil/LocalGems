package com.korzybskiemil.localgems.applicationuser.dto;

import java.util.UUID;

public record RegisteredUserDataDto(
        UUID id,
        String login
) {
}
