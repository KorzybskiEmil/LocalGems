package com.korzybskiemil.localgems.variousservices.dto;

import com.korzybskiemil.localgems.variousservices.common.ServiceOptions;

import java.util.UUID;

public record VariousServicesDto(
        UUID id,
        ServiceOptions serviceOptions,
        String description,
        int pricePerHour,
        String userNickname
) {
}
