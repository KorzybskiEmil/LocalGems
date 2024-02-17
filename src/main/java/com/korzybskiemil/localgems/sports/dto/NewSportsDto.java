package com.korzybskiemil.localgems.sports.dto;

import com.korzybskiemil.localgems.sports.common.ItemCondition;

import java.util.UUID;

public record NewSportsDto(
    String name,
    int price,
    ItemCondition condition,
    String description,
    UUID userUUID
) {
}
