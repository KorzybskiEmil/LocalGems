package com.korzybskiemil.localgems.car;


import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
    }

    @Test
    void shouldFindCarById() {
        //given:
        applicationUser.setId(UUID.randomUUID());
        Car expectedCar = new Car();
        expectedCar.setId(UUID.randomUUID());
        expectedCar = carRepository.save(expectedCar);
        //when:
        Optional<Car> car = carRepository.findById(expectedCar.getId());
        //then:
        assertThat(car)
                .isPresent()
                .map(Car::getId)
                .hasValue(expectedCar.getId());
    }

}