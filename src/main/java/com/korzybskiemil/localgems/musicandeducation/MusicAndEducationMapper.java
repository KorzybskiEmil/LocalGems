package com.korzybskiemil.localgems.musicandeducation;

import com.korzybskiemil.localgems.musicandeducation.dto.MusicAndEducationDto;
import com.korzybskiemil.localgems.musicandeducation.dto.NewMusicAndEducationDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MusicAndEducationMapper {

    public MusicAndEducation mapNewEntityToDto(NewMusicAndEducationDto dto) {
      return new MusicAndEducation(UUID.randomUUID(),
        dto.categoryType(),
        dto.name(),
        dto.price(),
        dto.description()
      );
    }

    public MusicAndEducationDto mapEntityToDto(MusicAndEducation entity) {
        return new MusicAndEducationDto(
        entity.getId(),
        entity.getCategoryType(),
        entity.getName(),
        entity.getPrice(),
        entity.getDescription()
        );
    }
}
