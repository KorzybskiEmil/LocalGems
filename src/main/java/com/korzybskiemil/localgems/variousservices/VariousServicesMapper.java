package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.variousservices.dto.NewVariousServicesDto;
import com.korzybskiemil.localgems.variousservices.dto.VariousServicesDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VariousServicesMapper {

    public VariousServices mapNewDtoToEntity(NewVariousServicesDto dto, ApplicationUser applicationUser) {
        return new VariousServices(
                UUID.randomUUID(),
                dto.serviceOptions(),
                dto.description(),
                dto.pricePerHour(),
                applicationUser
        );
    }

    public VariousServicesDto mapEntityToDto(VariousServices entity) {
        return new VariousServicesDto(
                entity.getId(),
                entity.getServiceOptions(),
                entity.getDescription(),
                entity.getPricePerHour(),
                entity.getUser().getNickname()
        );
    }
}
