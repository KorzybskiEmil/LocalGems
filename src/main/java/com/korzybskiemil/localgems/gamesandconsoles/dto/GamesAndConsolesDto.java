package com.korzybskiemil.localgems.gamesandconsoles.dto;

import com.korzybskiemil.localgems.gamesandconsoles.common.Platform;
import com.korzybskiemil.localgems.gamesandconsoles.common.SubCategory;
import com.korzybskiemil.localgems.gamesandconsoles.common.TechnicalCondition;

import java.util.UUID;

public record GamesAndConsolesDto(
        UUID id,
        SubCategory subCategory,
        Platform platform,
        String name,
        int price,
        TechnicalCondition technicalCondition,
        String description

) {
}
