package com.korzybskiemil.localgems.sports;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.sports.common.ItemCondition;
import com.korzybskiemil.localgems.sports.dto.NewSportsDto;
import com.korzybskiemil.localgems.sports.dto.SportsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SportsMapperTest {

    public static final String RANDOM_STRING = UUID.randomUUID().toString();
    private SportsMapper sportsMapper = new SportsMapper();
    private ApplicationUser applicationUser;


    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void mapNewDtoToEntity() {
        //given:
        NewSportsDto newSportsDto = new NewSportsDto(
                RANDOM_STRING,
                100,
                ItemCondition.NEW,
                RANDOM_STRING,
                applicationUser.getId()
        );
        //when:
        Sports sports = sportsMapper.mapNewDtoToEntity(newSportsDto, applicationUser);
        //then:
        assertThat(sports).isNotNull();
        assertThat(sports).extracting(Sports::getName).isEqualTo(newSportsDto.name());
        assertThat(sports).extracting(Sports::getPrice).isEqualTo(newSportsDto.price());
        assertThat(sports).extracting(Sports::getCondition).isEqualTo(newSportsDto.condition());
        assertThat(sports).extracting(Sports::getDescription).isEqualTo(newSportsDto.description());
    }

    @Test
    void mapEntityToDto() {
        //given:
        Sports sports = new Sports(
                UUID.randomUUID(),
                RANDOM_STRING,
                100,
                ItemCondition.NEW,
                RANDOM_STRING,
                applicationUser
        );
        //when:
        SportsDto sportsDto = sportsMapper.mapEntityToDto(sports);
        //then:
        assertThat(sportsDto).isNotNull();
        assertThat(sportsDto.id()).isEqualTo(sports.getId());
        assertThat(sportsDto.name()).isEqualTo(sports.getName());
        assertThat(sportsDto.price()).isEqualTo(sports.getPrice());
        assertThat(sportsDto.condition()).isEqualTo(sports.getCondition());
        assertThat(sportsDto.description()).isEqualTo(sports.getDescription());
    }
}