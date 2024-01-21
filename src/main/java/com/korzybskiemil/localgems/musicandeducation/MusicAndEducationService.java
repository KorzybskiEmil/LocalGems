package com.korzybskiemil.localgems.musicandeducation;

import com.korzybskiemil.localgems.musicandeducation.dto.MusicAndEducationDto;
import com.korzybskiemil.localgems.musicandeducation.dto.NewMusicAndEducationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MusicAndEducationService {

    private final MusicAndEducationRepository musicAndEducationRepository;
    private final MusicAndEducationMapper musicAndEducationMapper;

    public MusicAndEducationService(MusicAndEducationRepository musicAndEducationRepository, MusicAndEducationMapper musicAndEducationMapper) {
        this.musicAndEducationRepository = musicAndEducationRepository;
        this.musicAndEducationMapper = musicAndEducationMapper;
    }

    public List<MusicAndEducationDto> getMusicAndEducation() {
        return musicAndEducationRepository.findAll().stream()
                .map(musicAndEducationMapper::mapEntityToDto)
                .toList();
    }

    public MusicAndEducationDto createNewMusicAndEducation(NewMusicAndEducationDto newMusicAndEducationDto) {
        MusicAndEducation savedMusicAndEducation = musicAndEducationRepository.save(musicAndEducationMapper.mapNewEntityToDto(newMusicAndEducationDto));
        return musicAndEducationMapper.mapEntityToDto(savedMusicAndEducation);
    }

    public MusicAndEducationDto updateMusicAndEducation(UUID id, NewMusicAndEducationDto updateMusicAndEducationDto) {
        MusicAndEducation musicAndEducation = musicAndEducationRepository.findById(id)
                .orElseThrow(() -> getMusicAndEducationNotFoundException(id));

        musicAndEducation.setCategoryType(updateMusicAndEducationDto.categoryType());
        musicAndEducation.setName(updateMusicAndEducationDto.name());
        musicAndEducation.setPrice(updateMusicAndEducationDto.price());
        musicAndEducation.setDescription(updateMusicAndEducationDto.description());

        MusicAndEducation save = musicAndEducationRepository.save(musicAndEducation);
        return musicAndEducationMapper.mapEntityToDto(save);
    }

    public void deleteMusicAndEducation(UUID id) {
        musicAndEducationRepository.findById(id)
                .orElseThrow(() -> getMusicAndEducationNotFoundException(id));

        musicAndEducationRepository.deleteById(id);
    }

    private MusicAndEducationNotFoundException getMusicAndEducationNotFoundException(UUID id) {
        return new MusicAndEducationNotFoundException("Item with id: " + id + " does not exist");
    }
}
