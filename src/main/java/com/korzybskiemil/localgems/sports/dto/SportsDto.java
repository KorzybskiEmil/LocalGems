package com.korzybskiemil.localgems.sports.dto;

import com.korzybskiemil.localgems.sports.common.ItemCondition;

import java.util.UUID;

public record SportsDto(
        UUID id,
        String name,
        int price,
        ItemCondition condition,
        String description,
        String userNickname
) {
}
