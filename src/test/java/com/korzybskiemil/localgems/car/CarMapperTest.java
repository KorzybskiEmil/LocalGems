package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.car.common.*;
import com.korzybskiemil.localgems.car.dto.CarDto;
import com.korzybskiemil.localgems.car.dto.NewCarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    public static final String RANDOM_STRING = UUID.randomUUID().toString();
    private CarMapper carMapper;
    private ApplicationUser user;

    @BeforeEach
    void setUp() {
        carMapper = new CarMapper();
        user = new ApplicationUser("", "");
        user.setId(UUID.randomUUID());
    }

    @Test
    void mapNewDtoToEntity() {
        //given:
        NewCarDto newCarDto = new NewCarDto(
                RANDOM_STRING,
                RANDOM_STRING,
                BodyType.HATCHBACK,
                10000,
                2015,
                100000,
                150,
                RANDOM_STRING,
                RANDOM_STRING,
                RANDOM_STRING,
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
        //given:
        Car car = new Car(
                UUID.randomUUID(),
                RANDOM_STRING,
                RANDOM_STRING,
                BodyType.HATCHBACK,
                15000,
                2000,
                100000,
                140,
                RANDOM_STRING,
                RANDOM_STRING,
                RANDOM_STRING,
                TransmissionType.AUTOMATIC,
                FuelType.GASOLINE,
                DriveType.ALL_WHEEL_DRIVE,
                TechnicalCondition.NEW,
                user
        );
        //when:
        CarDto carDto = carMapper.mapEntityToDto(car);
        //then:
        assertThat(carDto).isNotNull();
        assertThat(carDto.id()).isEqualTo(car.getId());
        assertThat(carDto.brand()).isEqualTo(car.getBrand());
        assertThat(carDto.model()).isEqualTo(car.getModel());
        assertThat(carDto.bodyType()).isEqualTo(car.getBodyType());
        assertThat(carDto.price()).isEqualTo(car.getPrice());
        assertThat(carDto.yearOfProduction()).isEqualTo(car.getYearOfProduction());
        assertThat(carDto.mileage()).isEqualTo(car.getMileage());
        assertThat(carDto.enginePower()).isEqualTo(car.getEnginePower());
        assertThat(carDto.sellerDescription()).isEqualTo(car.getSellerDescription());
        assertThat(carDto.countryOfOrigin()).isEqualTo(car.getCountryOfOrigin());
        assertThat(carDto.colour()).isEqualTo(car.getColour());
        assertThat(carDto.transmissionType()).isEqualTo(car.getTransmissionType());
        assertThat(carDto.fuelType()).isEqualTo(car.getFuelType());
        assertThat(carDto.driveType()).isEqualTo(car.getDriveType());
        assertThat(carDto.technicalCondition()).isEqualTo(car.getTechnicalCondition());

    }
}