package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.applicationuser.dto.NewApplicationUserDto;
import com.korzybskiemil.localgems.car.common.*;
import com.korzybskiemil.localgems.car.dto.CarDto;
import com.korzybskiemil.localgems.car.dto.NewCarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    private final CarMapper carMapper = new CarMapper();
    private ApplicationUser user;

    @BeforeEach
    void setUp() {
        user = new ApplicationUser("", "");
        user.setId(UUID.randomUUID());
    }

    @Test
    void mapNewDtoToEntity() {
        //given:
        String randomString = UUID.randomUUID().toString();
        NewCarDto newCarDto = new NewCarDto(
                randomString,
                randomString,
                BodyType.HATCHBACK,
                10000,
                2015,
                100000,
                150,
                randomString,
                randomString,
                randomString,
                TransmissionType.AUTOMATIC,
                FuelType.ELECTRIC,
                DriveType.ALL_WHEEL_DRIVE,
                TechnicalCondition.NEW,
                user.getId()
        );
        //when:
        Car car = carMapper.mapNewDtoToEntity(newCarDto, user);
        //then;
        assertThat(car).isNotNull();
        assertThat(car).extracting(Car::getModel).isEqualTo(newCarDto.model());
        assertThat(car).extracting(Car::getBrand).isEqualTo(newCarDto.brand());
        assertThat(car).extracting(Car::getBodyType).isEqualTo(newCarDto.bodyType());
        assertThat(car).extracting(Car::getPrice).isEqualTo(newCarDto.price());
        assertThat(car).extracting(Car::getYearOfProduction).isEqualTo(newCarDto.yearOfProduction());
        assertThat(car).extracting(Car::getMileage).isEqualTo(newCarDto.mileage());
        assertThat(car).extracting(Car::getEnginePower).isEqualTo(newCarDto.enginePower());
        assertThat(car).extracting(Car::getSellerDescription).isEqualTo(newCarDto.sellerDescription());
        assertThat(car).extracting(Car::getCountryOfOrigin).isEqualTo(newCarDto.countryOfOrigin());
        assertThat(car).extracting(Car::getColour).isEqualTo(newCarDto.colour());
        assertThat(car).extracting(Car::getTransmissionType).isEqualTo(newCarDto.transmissionType());
        assertThat(car).extracting(Car::getFuelType).isEqualTo(newCarDto.fuelType());
        assertThat(car).extracting(Car::getDriveType).isEqualTo(newCarDto.driveType());
        assertThat(car).extracting(Car::getTechnicalCondition).isEqualTo(newCarDto.technicalCondition());
    }

    @Test
    void mapEntityToDto() {
    }
}