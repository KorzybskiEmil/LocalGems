package com.korzybskiemil.localgems.gamesandconsoles;

import com.korzybskiemil.localgems.gamesandconsoles.dto.GamesAndConsolesDto;
import com.korzybskiemil.localgems.gamesandconsoles.dto.NewGamesAndConsolesDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/games-and-consoles")
public class GamesAndConsolesController {

    private final GamesAndConsolesService gamesAndConsolesService;

    public GamesAndConsolesController(GamesAndConsolesService gamesAndConsolesService) {
        this.gamesAndConsolesService = gamesAndConsolesService;
    }

    @GetMapping
    public List<GamesAndConsolesDto> getGamesAndConsoles() {
        return gamesAndConsolesService.getGamesAndConsoles();
    }

    @PostMapping
    public GamesAndConsolesDto createNewGamesAndConsoles(@Valid @RequestBody NewGamesAndConsolesDto newGamesAndConsolesDto) {
        return gamesAndConsolesService.saveNewGamesAndConsoles(newGamesAndConsolesDto);
    }

    @PutMapping("/{id}")
    public GamesAndConsolesDto updateCar(@PathVariable UUID id, @Valid @RequestBody NewGamesAndConsolesDto updateGamesAndConsolesDto) {
        return gamesAndConsolesService.updateGamesAndConsoles(id, updateGamesAndConsolesDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGamesAndConsoles(@PathVariable UUID id) {
        gamesAndConsolesService.deleteGamesAndConsoles(id);
    }
}
