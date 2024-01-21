package com.korzybskiemil.localgems.gamesandconsoles;

import com.korzybskiemil.localgems.gamesandconsoles.dto.GamesAndConsolesDto;
import com.korzybskiemil.localgems.gamesandconsoles.dto.NewGamesAndConsolesDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GamesAndConsolesMapper {

    public GamesAndConsoles mapNewDtoToEntity(NewGamesAndConsolesDto dto) {
       return new GamesAndConsoles(
        UUID.randomUUID(),
        dto.name(),
        dto.subCategory(),
        dto.platform(),
        dto.price(),
        dto.technicalCondition(),
        dto.description()


       );
    }

    public GamesAndConsolesDto mapEntityToDto(GamesAndConsoles entity) {
    return new GamesAndConsolesDto(
        entity.getId(),
        entity.getSubCategory(),
        entity.getPlatform(),
        entity.getName(),
        entity.getPrice(),
        entity.getTechnicalCondition(),
        entity.getDescription()
    );
    }
}
