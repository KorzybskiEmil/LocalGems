package com.korzybskiemil.localgems.realestate;

import com.korzybskiemil.localgems.realestate.dto.NewRealEstateDto;
import com.korzybskiemil.localgems.realestate.dto.RealEstateDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/real-estate")
public class RealEstateController {

    private final RealEstateService realEstateService;

    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @PostMapping
    public RealEstateDto createNewRealEstate(@Valid @RequestBody NewRealEstateDto newRealEstateDto) {
        return realEstateService.saveNewRealEstate(newRealEstateDto);
    }

    @GetMapping
    public List<RealEstateDto> getRealEstate() {
        return realEstateService.getAllRealEstate();
    }

    @PutMapping("/{id}")
    public RealEstateDto updateRealEstate(@PathVariable UUID id, @Valid @RequestBody NewRealEstateDto updateRealEstateDto) {
        return realEstateService.updateRealEstate(id, updateRealEstateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRealEstate(@PathVariable UUID id) {
        realEstateService.deleteRealEstate(id);
    }
}
