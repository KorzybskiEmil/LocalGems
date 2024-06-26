package com.korzybskiemil.localgems.sports;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.sports.dto.NewSportsDto;
import com.korzybskiemil.localgems.sports.dto.SportsDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SportsMapper {

    public Sports mapNewDtoToEntity(NewSportsDto dto, ApplicationUser applicationUser) {
        return new Sports(
                UUID.randomUUID(),
                dto.name(),
                dto.price(),
                dto.condition(),
                dto.description(),
                applicationUser
        );
    }

    public SportsDto mapEntityToDto(Sports entity) {
        return new SportsDto(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCondition(),
                entity.getDescription()
        );
    }
}
