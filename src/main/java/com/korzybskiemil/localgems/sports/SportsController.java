package com.korzybskiemil.localgems.sports;

import com.korzybskiemil.localgems.sports.dto.NewSportsDto;
import com.korzybskiemil.localgems.sports.dto.SportsDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sports")
public class SportsController {

    private final SportsService sportsService;

    public SportsController(SportsService sportsService) {
        this.sportsService = sportsService;
    }

    @GetMapping
    public List<SportsDto> getAllSports() {
        return sportsService.getAllSports();
    }

    @PostMapping
    public SportsDto createNewSports(@Valid @RequestBody NewSportsDto newSportsDto) {
        return sportsService.saveNewSports(newSportsDto);
    }

    @PutMapping("/{id}")
    public SportsDto updateSports(@PathVariable UUID id, @Valid @RequestBody NewSportsDto updateSportsDto) {
        return sportsService.updateSports(id, updateSportsDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSports(@PathVariable UUID id) {
        sportsService.deleteSports(id);
    }
}
