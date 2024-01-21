package com.korzybskiemil.localgems.gamesandconsoles;

import com.korzybskiemil.localgems.gamesandconsoles.dto.GamesAndConsolesDto;
import com.korzybskiemil.localgems.gamesandconsoles.dto.NewGamesAndConsolesDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GamesAndConsolesService {

    private final GamesAndConsolesMapper gamesAndConsolesMapper;
    private final GamesAndConsolesRepository gamesAndConsolesRepository;

    public GamesAndConsolesService(GamesAndConsolesMapper gamesAndConsolesMapper, GamesAndConsolesRepository gamesAndConsolesRepository) {
        this.gamesAndConsolesMapper = gamesAndConsolesMapper;
        this.gamesAndConsolesRepository = gamesAndConsolesRepository;
    }

    public GamesAndConsolesDto saveNewGamesAndConsoles(NewGamesAndConsolesDto newGamesAndConsolesDto) {
        GamesAndConsoles savedGamesAndConsoles = gamesAndConsolesRepository.save(gamesAndConsolesMapper.mapNewDtoToEntity(newGamesAndConsolesDto));
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
}
