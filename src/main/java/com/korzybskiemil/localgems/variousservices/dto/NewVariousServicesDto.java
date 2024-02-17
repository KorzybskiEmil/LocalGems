package com.korzybskiemil.localgems.variousservices.dto;

import com.korzybskiemil.localgems.variousservices.common.ServiceOptions;

import java.util.UUID;

public record NewVariousServicesDto(
        ServiceOptions serviceOptions,
        String description,
        int pricePerHour,
        UUID userUUID
) {
}
