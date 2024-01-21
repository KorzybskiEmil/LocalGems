package com.korzybskiemil.localgems.car.dto;

import com.korzybskiemil.localgems.car.common.*;

public record NewCarDto(
        String brand,
        String model,
        BodyType bodyType,
        int price,
        int yearOfProduction,
        int mileage,
        int enginePower,
        String sellerDescription,
        String countryOfOrigin,
        String colour,
        TransmissionType transmissionType,
        FuelType fuelType,
        DriveType driveType,
        TechnicalCondition technicalCondition
) {
}
