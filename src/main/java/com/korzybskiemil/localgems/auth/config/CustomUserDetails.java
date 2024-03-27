package com.korzybskiemil.localgems.auth.config;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface CustomUserDetails extends UserDetails {

    UUID getId();
}
