package com.korzybskiemil.localgems.sports;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.UUID;


@DataJpaTest
class SportsRepositoryTest {

    @Autowired
    private SportsRepository sportsRepository;
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void findSportsById() {
        //given:
        Sports expected = new Sports();
        expected.setId(UUID.randomUUID());
        expected = sportsRepository.save(expected);
        //when:
        Optional<Sports> sports = sportsRepository.findById(expected.getId());
        //then:
        assertThat(sports)
                .isPresent()
                .map(Sports::getId)
                .hasValue(expected.getId());
    }
}