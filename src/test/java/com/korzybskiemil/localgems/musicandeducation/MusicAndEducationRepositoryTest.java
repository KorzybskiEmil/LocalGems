package com.korzybskiemil.localgems.musicandeducation;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MusicAndEducationRepositoryTest {

    @Autowired
    private MusicAndEducationRepository musicAndEducationRepository;
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void findMusicAndEducationById() {
        //given:
        MusicAndEducation expected = new MusicAndEducation();
        expected.setId(UUID.randomUUID());
        expected = musicAndEducationRepository.save(expected);
        //when:
        Optional<MusicAndEducation> musicAndEducation = musicAndEducationRepository.findById(expected.getId());
        //then:
        assertThat(musicAndEducation)
                .isPresent()
                .map(MusicAndEducation::getId)
                .hasValue(expected.getId());
    }
}