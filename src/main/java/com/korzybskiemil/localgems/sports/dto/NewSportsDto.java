package com.korzybskiemil.localgems.sports.dto;

import com.korzybskiemil.localgems.sports.common.ItemCondition;

public record NewSportsDto(
    String name,
    int price,
    ItemCondition condition,
    String description
) {
}
