package com.korzybskiemil.localgems.realestate;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RealEstateRepositoryTest {
    @Autowired
    private RealEstateRepository realEstateRepository;
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void findRealEstateById() {
        //given:
        RealEstate expected = new RealEstate();
        expected.setId(UUID.randomUUID());
        expected = realEstateRepository.save(expected);
        //when:
        Optional<RealEstate> realEstate = realEstateRepository.findById(expected.getId());
        //then:
        assertThat(realEstate)
                .isPresent()
                .map(RealEstate::getId)
                .hasValue(expected.getId());
    }
}