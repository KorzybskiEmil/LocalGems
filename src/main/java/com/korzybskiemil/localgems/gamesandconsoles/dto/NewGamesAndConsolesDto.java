package com.korzybskiemil.localgems.gamesandconsoles.dto;

import com.korzybskiemil.localgems.gamesandconsoles.common.Platform;
import com.korzybskiemil.localgems.gamesandconsoles.common.SubCategory;
import com.korzybskiemil.localgems.gamesandconsoles.common.TechnicalCondition;

import java.util.UUID;

public record NewGamesAndConsolesDto(
        String name,
        SubCategory subCategory,
        Platform platform,
        int price,
        TechnicalCondition technicalCondition,
        String description,
        UUID userUUID
) {
}
