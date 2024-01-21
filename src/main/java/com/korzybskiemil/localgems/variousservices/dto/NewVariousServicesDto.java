package com.korzybskiemil.localgems.variousservices.dto;

import com.korzybskiemil.localgems.variousservices.common.ServiceOptions;

public record NewVariousServicesDto(
        ServiceOptions serviceOptions,
        String description,
        int pricePerHour
) {
}
