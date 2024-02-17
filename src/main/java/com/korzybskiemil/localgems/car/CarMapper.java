package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.car.dto.CarDto;
import com.korzybskiemil.localgems.car.dto.NewCarDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CarMapper {

    public Car mapNewDtoToEntity(NewCarDto dto, ApplicationUser applicationUser) {
        return new Car(
                UUID.randomUUID(),
                dto.brand(),
                dto.model(),
                dto.bodyType(),
                dto.price(),
                dto.yearOfProduction(),
                dto.mileage(),
                dto.enginePower(),
                dto.sellerDescription(),
                dto.countryOfOrigin(),
                dto.colour(),
                dto.transmissionType(),
                dto.fuelType(),
                dto.driveType(),
                dto.technicalCondition(),
                applicationUser
        );
    }


    public CarDto mapEntityToDto(Car entity) {
        return new CarDto(
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getBodyType(),
                entity.getPrice(),
                entity.getYearOfProduction(),
                entity.getMileage(),
                entity.getEnginePower(),
                entity.getSellerDescription(),
                entity.getCountryOfOrigin(),
                entity.getColour(),
                entity.getTransmissionType(),
                entity.getFuelType(),
                entity.getDriveType(),
                entity.getTechnicalCondition(),
                entity.getUser().getNickname()
        );
    }
}
