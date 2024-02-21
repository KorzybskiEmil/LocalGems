package com.korzybskiemil.localgems.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.security.jwt.token")
public record AuthConfigProperties(
        String secret,
        int validity
) {
}
