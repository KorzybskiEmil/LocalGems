package com.korzybskiemil.localgems.gamesandconsoles;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserNotFoundException;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserRepository;
import com.korzybskiemil.localgems.gamesandconsoles.dto.GamesAndConsolesDto;
import com.korzybskiemil.localgems.gamesandconsoles.dto.NewGamesAndConsolesDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GamesAndConsolesService {

    private final GamesAndConsolesMapper gamesAndConsolesMapper;
    private final GamesAndConsolesRepository gamesAndConsolesRepository;
    private final ApplicationUserRepository applicationUserRepository;

    public GamesAndConsolesService(GamesAndConsolesMapper gamesAndConsolesMapper, GamesAndConsolesRepository gamesAndConsolesRepository, ApplicationUserRepository applicationUserRepository) {
        this.gamesAndConsolesMapper = gamesAndConsolesMapper;
        this.gamesAndConsolesRepository = gamesAndConsolesRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    public GamesAndConsolesDto saveNewGamesAndConsoles(NewGamesAndConsolesDto newGamesAndConsolesDto) {
        ApplicationUser applicationUser = applicationUserRepository.findById(newGamesAndConsolesDto.userUUID())
                .orElseThrow(() -> getApplicationUserNotFoundException(newGamesAndConsolesDto.userUUID()));

        GamesAndConsoles savedGamesAndConsoles = gamesAndConsolesRepository.save(gamesAndConsolesMapper.mapNewDtoToEntity(newGamesAndConsolesDto, applicationUser));
        return gamesAndConsolesMapper.mapEntityToDto(savedGamesAndConsoles);
    }


    public List<GamesAndConsolesDto> getGamesAndConsoles() {
        return gamesAndConsolesRepository.findAll().stream()
                .map(gamesAndConsolesMapper::mapEntityToDto)
                .toList();
    }

    public GamesAndConsolesDto updateGamesAndConsoles(UUID id, NewGamesAndConsolesDto updateGamesAndConsolesDto) {
        GamesAndConsoles gamesAndConsoles = gamesAndConsolesRepository.findById(id)
                .orElseThrow(() -> getGamesAndConsolesNotFoundException(id));

        gamesAndConsoles.setName(updateGamesAndConsolesDto.name());
        gamesAndConsoles.setSubCategory(updateGamesAndConsolesDto.subCategory());
        gamesAndConsoles.setPlatform(updateGamesAndConsolesDto.platform());
        gamesAndConsoles.setPrice(updateGamesAndConsolesDto.price());
        gamesAndConsoles.setTechnicalCondition(updateGamesAndConsolesDto.technicalCondition());
        gamesAndConsoles.setDescription(updateGamesAndConsolesDto.description());

        GamesAndConsoles save = gamesAndConsolesRepository.save(gamesAndConsoles);
        return gamesAndConsolesMapper.mapEntityToDto(save);
    }

    public void deleteGamesAndConsoles(UUID id) {
        gamesAndConsolesRepository.findById(id)
                .orElseThrow(() -> getGamesAndConsolesNotFoundException(id));

        gamesAndConsolesRepository.deleteById(id);
    }

    private GamesAndConsolesNotFoundException getGamesAndConsolesNotFoundException(UUID id) {
        return new GamesAndConsolesNotFoundException("Item with id: " + id + " does not exist");
    }

    private ApplicationUserNotFoundException getApplicationUserNotFoundException(UUID applicationUserId) {
        return new ApplicationUserNotFoundException("Application User with id: " + applicationUserId + " does not exist");
    }
}
