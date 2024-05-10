package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.variousservices.common.ServiceOptions;
import com.korzybskiemil.localgems.variousservices.dto.NewVariousServicesDto;
import com.korzybskiemil.localgems.variousservices.dto.VariousServicesDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VariousServicesMapperTest {
    public static final String RANDOM_STRING = UUID.randomUUID().toString();
    private VariousServicesMapper variousServicesMapper = new VariousServicesMapper();
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void mapNewDtoToEntity() {
        //given:
        NewVariousServicesDto newVariousServicesDto = new NewVariousServicesDto(
                ServiceOptions.IT_SERVICES,
                RANDOM_STRING,
                125,
                applicationUser.getId()
        );
        //when:
        VariousServices variousServices = variousServicesMapper.mapNewDtoToEntity(newVariousServicesDto, applicationUser);
        //then:
        assertThat(variousServices).isNotNull();
        assertThat(variousServices).extracting(VariousServices::getServiceOptions).isEqualTo(newVariousServicesDto.serviceOptions());
        assertThat(variousServices).extracting(VariousServices::getDescription).isEqualTo(newVariousServicesDto.description());
        assertThat(variousServices).extracting(VariousServices::getPricePerHour).isEqualTo(newVariousServicesDto.pricePerHour());

    }

    @Test
    void mapEntityToDto() {
        //given:
        VariousServices variousServices = new VariousServices(
                UUID.randomUUID(),
                ServiceOptions.IT_SERVICES,
                RANDOM_STRING,
                125,
                applicationUser
        );
        //when:
        VariousServicesDto variousServicesDto = variousServicesMapper.mapEntityToDto(variousServices);
        //then:
        assertThat(variousServicesDto).isNotNull();
        assertThat(variousServicesDto.id()).isEqualTo(variousServices.getId());
        assertThat(variousServicesDto.serviceOptions()).isEqualTo(variousServices.getServiceOptions());
        assertThat(variousServicesDto.description()).isEqualTo(variousServices.getDescription());
        assertThat(variousServicesDto.pricePerHour()).isEqualTo(variousServices.getPricePerHour());

    }
}