package com.korzybskiemil.localgems.applicationuser;

import com.korzybskiemil.localgems.applicationuser.dto.ApplicationUserDto;
import com.korzybskiemil.localgems.applicationuser.dto.NewApplicationUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;
    private final ApplicationUserMapper applicationUserMapper;

    public ApplicationUserService(ApplicationUserRepository applicationUserRepository, ApplicationUserMapper applicationUserMapper) {
        this.applicationUserRepository = applicationUserRepository;
        this.applicationUserMapper = applicationUserMapper;
    }

//    public ApplicationUserDto saveNewApplicationUser(NewApplicationUserDto newApplicationUserDto) {
//        ApplicationUser savedApplicationUser = applicationUserRepository.save(applicationUserMapper.mapNewDtoToEntity(newApplicationUserDto));
//        return applicationUserMapper.mapEntityToDto(savedApplicationUser);
//    }

    public List<ApplicationUserDto> getAllApplicationUsers() {
        return applicationUserRepository.findAll().stream()
                .map(applicationUserMapper::mapEntityToDto)
                .toList();
    }

    public ApplicationUserDto getOneById(UUID id) {
        return applicationUserRepository.findById(id)
                .map(applicationUserMapper::mapEntityToDto)
                .orElse(null);
    }


    public ApplicationUserDto updateApplicationUser(UUID id, NewApplicationUserDto updatedApplicationUserDto) {
        ApplicationUser applicationUser = applicationUserRepository.findById(id)
                .orElseThrow(() -> getApplicationUserNotFoundException(id));

        applicationUser.setUsername(updatedApplicationUserDto.username());
        applicationUser.setPassword(updatedApplicationUserDto.password());

        ApplicationUser save = applicationUserRepository.save(applicationUser);
        return applicationUserMapper.mapEntityToDto(save);
    }

    public void deleteApplicationUser(UUID id) {
        applicationUserRepository.findById(id)
                .orElseThrow(() -> getApplicationUserNotFoundException(id));

        applicationUserRepository.deleteById(id);
    }

    private ApplicationUserNotFoundException getApplicationUserNotFoundException(UUID id) {
        return new ApplicationUserNotFoundException("Application user with id: " + id + " does not exist");
    }

}

