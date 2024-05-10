package com.korzybskiemil.localgems.musicandeducation;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.musicandeducation.common.CategoryType;
import com.korzybskiemil.localgems.musicandeducation.dto.MusicAndEducationDto;
import com.korzybskiemil.localgems.musicandeducation.dto.NewMusicAndEducationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class MusicAndEducationMapperTest {

    public static final String RANDOM_STRING = UUID.randomUUID().toString();
    private MusicAndEducationMapper musicAndEducationMapper;
    ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        musicAndEducationMapper = new MusicAndEducationMapper();
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void mapNewEntityToDto() {
        //given:
        NewMusicAndEducationDto newMusicAndEducationDto = new NewMusicAndEducationDto(
                CategoryType.MUSIC,
                RANDOM_STRING,
                100,
                RANDOM_STRING,
                applicationUser.getId()
        );
        //when:
        MusicAndEducation musicAndEducation = musicAndEducationMapper.mapNewEntityToDto(newMusicAndEducationDto, applicationUser);
        //then:
        assertThat(musicAndEducation).isNotNull();
        assertThat(musicAndEducation).extracting(MusicAndEducation::getCategoryType).isEqualTo(newMusicAndEducationDto.categoryType());
        assertThat(musicAndEducation).extracting(MusicAndEducation::getName).isEqualTo(newMusicAndEducationDto.name());
        assertThat(musicAndEducation).extracting(MusicAndEducation::getPrice).isEqualTo(newMusicAndEducationDto.price());
        assertThat(musicAndEducation).extracting(MusicAndEducation::getDescription).isEqualTo(newMusicAndEducationDto.description());
    }

    @Test
    void mapEntityToDto() {
        //given:
        MusicAndEducation musicAndEducation = new MusicAndEducation(
                UUID.randomUUID(),
                CategoryType.MUSIC,
                RANDOM_STRING,
                200,
                RANDOM_STRING,
                applicationUser
        );
        //when:
        MusicAndEducationDto musicAndEducationDto = musicAndEducationMapper.mapEntityToDto(musicAndEducation);
        //then:
        assertThat(musicAndEducationDto).isNotNull();
        assertThat(musicAndEducationDto.id()).isEqualTo(musicAndEducation.getId());
        assertThat(musicAndEducationDto.categoryType()).isEqualTo(musicAndEducation.getCategoryType());
        assertThat(musicAndEducationDto.name()).isEqualTo(musicAndEducation.getName());
        assertThat(musicAndEducationDto.price()).isEqualTo(musicAndEducation.getPrice());
        assertThat(musicAndEducationDto.description()).isEqualTo(musicAndEducation.getDescription());
    }
}