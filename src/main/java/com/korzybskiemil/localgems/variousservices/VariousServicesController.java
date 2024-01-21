package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.variousservices.dto.NewVariousServicesDto;
import com.korzybskiemil.localgems.variousservices.dto.VariousServicesDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/various-services")
public class VariousServicesController {

    private final VariousServicesService variousServicesService;

    public VariousServicesController(VariousServicesService variousServicesService) {
        this.variousServicesService = variousServicesService;
    }

    @GetMapping
    public List<VariousServicesDto> getAllSports() {
        return variousServicesService.getAllVariousServices();
    }

    @PostMapping
    public VariousServicesDto createNewSports(@Valid @RequestBody NewVariousServicesDto newVariousServicesDto) {
        return variousServicesService.saveNewVariousServices(newVariousServicesDto);
    }

    @PutMapping("/{id}")
    public VariousServicesDto updateVariousServices(@PathVariable UUID id, @Valid @RequestBody NewVariousServicesDto updateVariousServices) {
        return variousServicesService.updateVariousServices(id, updateVariousServices);
    }

    @DeleteMapping("/{id}")
    public void deleteVariousServices(@PathVariable UUID id) {
        variousServicesService.deleteVariousServices(id);
    }
}
