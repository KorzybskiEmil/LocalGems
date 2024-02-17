package com.korzybskiemil.localgems.sports;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserNotFoundException;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserRepository;
import com.korzybskiemil.localgems.sports.dto.NewSportsDto;
import com.korzybskiemil.localgems.sports.dto.SportsDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SportsService {

    private final SportsRepository sportsRepository;
    private final ApplicationUserRepository applicationUserRepository;

    private final SportsMapper sportsMapper;

    public SportsService(SportsRepository sportsRepository, ApplicationUserRepository applicationUserRepository, SportsMapper sportsMapper) {
        this.sportsRepository = sportsRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.sportsMapper = sportsMapper;
    }

    public SportsDto saveNewSports(NewSportsDto newSportsDto) {
        ApplicationUser applicationUser = applicationUserRepository.findById(newSportsDto.userUUID())
                .orElseThrow(() -> getApplicationUserNotFoundException(newSportsDto.userUUID()));

        Sports savedSports = sportsRepository.save(sportsMapper.mapNewDtoToEntity(newSportsDto, applicationUser));
        return sportsMapper.mapEntityToDto(savedSports);
    }

    public List<SportsDto> getAllSports() {
        return sportsRepository.findAll().stream()
                .map(sportsMapper::mapEntityToDto)
                .toList();
    }

    public SportsDto updateSports(UUID id, @Valid NewSportsDto updateSportsDto) {
        Sports sports = sportsRepository.findById(id)
                .orElseThrow(() -> getSportsNotFoundException(id));

        sports.setName(updateSportsDto.name());
        sports.setPrice(updateSportsDto.price());
        sports.setCondition(updateSportsDto.condition());
        sports.setDescription(updateSportsDto.description());

        Sports save = sportsRepository.save(sports);
        return sportsMapper.mapEntityToDto(save);
    }

    public void deleteSports(UUID id) {
        sportsRepository.findById(id)
                .orElseThrow(() -> getSportsNotFoundException(id));

        sportsRepository.deleteById(id);
    }

    private SportsNotFoundException getSportsNotFoundException(UUID id) {
        return new SportsNotFoundException("Item with id: " + id + " does not exist");
    }

    private ApplicationUserNotFoundException getApplicationUserNotFoundException(UUID applicationUserId) {
        return new ApplicationUserNotFoundException("Application User with id: " + applicationUserId + " does not exist");
    }

}
