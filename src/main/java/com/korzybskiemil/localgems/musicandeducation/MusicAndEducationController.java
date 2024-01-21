package com.korzybskiemil.localgems.musicandeducation;

import com.korzybskiemil.localgems.musicandeducation.dto.MusicAndEducationDto;
import com.korzybskiemil.localgems.musicandeducation.dto.NewMusicAndEducationDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/music-and-education")
public class MusicAndEducationController {

    private final MusicAndEducationService musicAndEducationService;

    public MusicAndEducationController(MusicAndEducationService musicAndEducationService) {
        this.musicAndEducationService = musicAndEducationService;
    }

    @GetMapping
    public List<MusicAndEducationDto> getMusicAndEducation() {
        return musicAndEducationService.getMusicAndEducation();
    }

    @PostMapping
    public MusicAndEducationDto createNewMusicAndEducation(@Valid @RequestBody NewMusicAndEducationDto newMusicAndEducationDto) {
        return musicAndEducationService.createNewMusicAndEducation(newMusicAndEducationDto);
    }

    @PutMapping("/{id}")
    public MusicAndEducationDto updateMusicAndInstruments(@PathVariable UUID id, @Valid @RequestBody NewMusicAndEducationDto updateMusicAndInstrumentsDto) {
        return musicAndEducationService.updateMusicAndEducation(id, updateMusicAndInstrumentsDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMusicAndEducation(@PathVariable UUID id) {
        musicAndEducationService.deleteMusicAndEducation(id);
    }
}
