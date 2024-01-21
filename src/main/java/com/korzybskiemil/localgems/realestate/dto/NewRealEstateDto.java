package com.korzybskiemil.localgems.realestate.dto;

import com.korzybskiemil.localgems.realestate.common.Floor;
import com.korzybskiemil.localgems.realestate.common.Furnitured;
import com.korzybskiemil.localgems.realestate.common.HousingType;
import com.korzybskiemil.localgems.realestate.common.SubCategory;

public record NewRealEstateDto(
        SubCategory subCategory,
        HousingType housingType,
        int price,
        int surfaceArea,
        Floor floor,
        Furnitured furnitured,
        int numberOfRooms,
        String description
) {
}
