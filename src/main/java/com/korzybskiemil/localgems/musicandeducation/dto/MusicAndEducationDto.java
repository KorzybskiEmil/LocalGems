package com.korzybskiemil.localgems.musicandeducation.dto;

import com.korzybskiemil.localgems.musicandeducation.common.CategoryType;

import java.util.UUID;

public record MusicAndEducationDto(
        UUID id,
        CategoryType categoryType,
        String name,
        int price,
        String description
) {
}
