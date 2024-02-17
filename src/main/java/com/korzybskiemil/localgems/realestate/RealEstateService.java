package com.korzybskiemil.localgems.realestate;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserNotFoundException;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserRepository;
import com.korzybskiemil.localgems.realestate.dto.NewRealEstateDto;
import com.korzybskiemil.localgems.realestate.dto.RealEstateDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RealEstateService {

    private final RealEstateRepository realEstateRepository;
    private final ApplicationUserRepository applicationUserRepository;

    private final RealEstateMapper realEstateMapper;

    public RealEstateService(RealEstateRepository realEstateRepository, ApplicationUserRepository applicationUserRepository, RealEstateMapper realEstateMapper) {
        this.realEstateRepository = realEstateRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.realEstateMapper = realEstateMapper;
    }

    public RealEstateDto saveNewRealEstate(NewRealEstateDto newRealEstateDto) {
        ApplicationUser applicationUser = applicationUserRepository.findById(newRealEstateDto.userUUID())
                .orElseThrow(() -> getApplicationUserNotFoundException(newRealEstateDto.userUUID()));

        RealEstate savedRealEstate = realEstateRepository.save(realEstateMapper.mapNewDtoToEntity(newRealEstateDto, applicationUser));
        return realEstateMapper.mapEntityToDto(savedRealEstate);
    }

    public List<RealEstateDto> getAllRealEstate() {
        return realEstateRepository.findAll().stream()
                .map(realEstateMapper::mapEntityToDto)
                .toList();
    }

    public RealEstateDto updateRealEstate(UUID id, @Valid NewRealEstateDto updateRealEstateDto) {
        RealEstate realEstate = realEstateRepository.findById(id)
                .orElseThrow(() -> getRealEstateNotFoundException(id));

        realEstate.setSubCategory(updateRealEstateDto.subCategory());
        realEstate.setHousingType(updateRealEstateDto.housingType());
        realEstate.setPrice(updateRealEstateDto.price());
        realEstate.setSurfaceArea(updateRealEstateDto.surfaceArea());
        realEstate.setFloor(updateRealEstateDto.floor());
        realEstate.setFurnitured(updateRealEstateDto.furnitured());
        realEstate.setNumberOfRooms(updateRealEstateDto.numberOfRooms());
        realEstate.setDescription(updateRealEstateDto.description());

        RealEstate save = realEstateRepository.save(realEstate);
        return realEstateMapper.mapEntityToDto(save);
    }

    public void deleteRealEstate(UUID id) {
        realEstateRepository.findById(id)
                .orElseThrow(() -> getRealEstateNotFoundException(id));

        realEstateRepository.deleteById(id);
    }

    private RealEstateNotFoundException getRealEstateNotFoundException(UUID id) {
        return new RealEstateNotFoundException("Item with id: " + id + " does not exist");
    }

    private ApplicationUserNotFoundException getApplicationUserNotFoundException(UUID applicationUserId) {
        return new ApplicationUserNotFoundException("Application User with id: " + applicationUserId + " does not exist");
    }
}
