package com.korzybskiemil.localgems.applicationuser;

import com.korzybskiemil.localgems.applicationuser.dto.ApplicationUserDto;
import com.korzybskiemil.localgems.applicationuser.dto.NewApplicationUserDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApplicationUserMapper {

    public ApplicationUser mapNewDtoToEntity(NewApplicationUserDto dto) {
        return new ApplicationUser(
                UUID.randomUUID(),
                dto.firstName(),
                dto.lastName(),
                dto.nickname(),
                dto.email()
        );
    }

    public ApplicationUserDto mapEntityToDto(ApplicationUser entity) {
        return new ApplicationUserDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNickname(),
                entity.getEmail()
        );
    }
}
