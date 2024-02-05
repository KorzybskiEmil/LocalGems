package com.korzybskiemil.localgems.musicandeducation.dto;

import com.korzybskiemil.localgems.musicandeducation.common.CategoryType;

public record NewMusicAndEducationDto(
        CategoryType categoryType, //string
        String name,
        int price,
        String description
) {
}
