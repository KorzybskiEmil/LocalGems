package com.korzybskiemil.localgems.work;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class WorkRepositoryTest {

    @Autowired
    private WorkRepository workRepository;
    private ApplicationUser applicationUser;


    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void findWorkById() {
        //given:
        Work expected = new Work();
        expected.setId(UUID.randomUUID());
        expected = workRepository.save(expected);
        //when:
        Optional<Work> work = workRepository.findById(expected.getId());
        //then:
        assertThat(work)
                .isPresent()
                .map(Work::getId)
                .hasValue(expected.getId());
    }
}