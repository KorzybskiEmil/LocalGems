package com.korzybskiemil.localgems.realestate.dto;

import com.korzybskiemil.localgems.realestate.common.Floor;
import com.korzybskiemil.localgems.realestate.common.Furnitured;
import com.korzybskiemil.localgems.realestate.common.HousingType;
import com.korzybskiemil.localgems.realestate.common.SubCategory;

import java.util.UUID;

public record RealEstateDto(
        UUID id,
        SubCategory subCategory,
        HousingType housingType,
        int price,
        int surfaceArea,
        Floor floor,
        Furnitured furnitured,
        int numberOfRooms,
        String description,
        String userNickname
) {
}
