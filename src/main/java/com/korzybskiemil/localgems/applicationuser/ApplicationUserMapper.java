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
                dto.nickname(),
                dto.email(),
                dto.password()
        );
    }

    public ApplicationUserDto mapEntityToDto(ApplicationUser entity) {
        return new ApplicationUserDto(
                entity.getId(),
                entity.getNickname(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
