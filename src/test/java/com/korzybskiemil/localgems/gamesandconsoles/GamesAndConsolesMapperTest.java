package com.korzybskiemil.localgems.gamesandconsoles;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.gamesandconsoles.common.Platform;
import com.korzybskiemil.localgems.gamesandconsoles.common.SubCategory;
import com.korzybskiemil.localgems.gamesandconsoles.common.TechnicalCondition;
import com.korzybskiemil.localgems.gamesandconsoles.dto.GamesAndConsolesDto;
import com.korzybskiemil.localgems.gamesandconsoles.dto.NewGamesAndConsolesDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class GamesAndConsolesMapperTest {

    public static final String RANDOM_STRING = UUID.randomUUID().toString();
    private final GamesAndConsolesMapper gamesAndConsolesMapper = new GamesAndConsolesMapper();
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void mapNewDtoToEntity() {
        //given:
        NewGamesAndConsolesDto newGamesAndConsolesDto = new NewGamesAndConsolesDto(
                RANDOM_STRING,
                SubCategory.CONSOLES,
                Platform.PLAYSTATION,
                100,
                TechnicalCondition.DAMAGED,
                RANDOM_STRING,
                applicationUser.getId()
        );
        //when:
        GamesAndConsoles gamesAndConsoles = gamesAndConsolesMapper.mapNewDtoToEntity(newGamesAndConsolesDto, applicationUser);
        //then:
        assertThat(gamesAndConsoles).isNotNull();
        assertThat(gamesAndConsoles).extracting(GamesAndConsoles::getName).isEqualTo(newGamesAndConsolesDto.name());
        assertThat(gamesAndConsoles).extracting(GamesAndConsoles::getSubCategory).isEqualTo(newGamesAndConsolesDto.subCategory());
        assertThat(gamesAndConsoles).extracting(GamesAndConsoles::getPlatform).isEqualTo(newGamesAndConsolesDto.platform());
        assertThat(gamesAndConsoles).extracting(GamesAndConsoles::getPrice).isEqualTo(newGamesAndConsolesDto.price());
        assertThat(gamesAndConsoles).extracting(GamesAndConsoles::getTechnicalCondition).isEqualTo(newGamesAndConsolesDto.technicalCondition());
        assertThat(gamesAndConsoles).extracting(GamesAndConsoles::getDescription).isEqualTo(newGamesAndConsolesDto.description());
    }

    @Test
    void mapEntityToDto() {
        //given:
        GamesAndConsoles gamesAndConsoles = new GamesAndConsoles(
                UUID.randomUUID(),
                RANDOM_STRING,
                SubCategory.GAMES,
                Platform.PLAYSTATION,
                200,
                TechnicalCondition.NEW,
                RANDOM_STRING,
                applicationUser
        );
        //when:
        GamesAndConsolesDto gamesAndConsolesDto = gamesAndConsolesMapper.mapEntityToDto(gamesAndConsoles);
        //then:
        assertThat(gamesAndConsolesDto).isNotNull();
        assertThat(gamesAndConsolesDto.id()).isEqualTo(gamesAndConsoles.getId());
        assertThat(gamesAndConsolesDto.subCategory()).isEqualTo(gamesAndConsoles.getSubCategory());
        assertThat(gamesAndConsolesDto.platform()).isEqualTo(gamesAndConsoles.getPlatform());
        assertThat(gamesAndConsolesDto.name()).isEqualTo(gamesAndConsoles.getName());
        assertThat(gamesAndConsolesDto.price()).isEqualTo(gamesAndConsoles.getPrice());
        assertThat(gamesAndConsolesDto.technicalCondition()).isEqualTo(gamesAndConsoles.getTechnicalCondition());
        assertThat(gamesAndConsolesDto.description()).isEqualTo(gamesAndConsoles.getDescription());
    }
}