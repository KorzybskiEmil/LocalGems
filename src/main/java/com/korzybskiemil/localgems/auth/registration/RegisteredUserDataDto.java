package com.korzybskiemil.localgems.auth.registration;

import java.util.UUID;

public record RegisteredUserDataDto(
        UUID id,
        String login
) {
}
