package com.korzybskiemil.localgems.realestate;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.realestate.dto.NewRealEstateDto;
import com.korzybskiemil.localgems.realestate.dto.RealEstateDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RealEstateMapper {

    public RealEstate mapNewDtoToEntity(NewRealEstateDto dto, ApplicationUser applicationUser) {
        return new RealEstate(
                UUID.randomUUID(),
                dto.subCategory(),
                dto.housingType(),
                dto.price(),
                dto.surfaceArea(),
                dto.floor(),
                dto.furnitured(),
                dto.numberOfRooms(),
                dto.description(),
                applicationUser
        );
    }

    public RealEstateDto mapEntityToDto(RealEstate entity) {
        return new RealEstateDto(
                entity.getId(),
                entity.getSubCategory(),
                entity.getHousingType(),
                entity.getPrice(),
                entity.getSurfaceArea(),
                entity.getFloor(),
                entity.getFurnitured(),
                entity.getNumberOfRooms(),
                entity.getDescription(),
                entity.getUser().getNickname()
        );
    }
}
