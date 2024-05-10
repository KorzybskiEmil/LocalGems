package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class VariousServicesRepositoryTest {

    @Autowired
    private VariousServicesRepository variousServicesRepository;
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void findVariousServicesById() {
        //given:
        VariousServices expected = new VariousServices();
        expected.setId(UUID.randomUUID());
        expected = variousServicesRepository.save(expected);
        //when:
        Optional<VariousServices> variousServices = variousServicesRepository.findById(expected.getId());
        //then:
        assertThat(variousServices)
                .isPresent()
                .map(VariousServices::getId)
                .hasValue(expected.getId());

    }
}