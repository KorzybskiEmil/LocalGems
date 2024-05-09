package com.korzybskiemil.localgems.gamesandconsoles;


import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class GamesAndConsolesRepositoryTest {

    @Autowired
    private GamesAndConsolesRepository gamesAndConsolesRepository;
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void findGamesAndConsolesById() {
        //given:
        GamesAndConsoles expected = new GamesAndConsoles();
        expected.setId(UUID.randomUUID());
        expected = gamesAndConsolesRepository.save(expected);
        //when:
        Optional<GamesAndConsoles> gamesAndConsoles = gamesAndConsolesRepository.findById(expected.getId());
        //then:
        assertThat(gamesAndConsoles)
                .isPresent()
                .map(GamesAndConsoles::getId)
                .hasValue(expected.getId());

    }
}