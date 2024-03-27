package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.auth.config.CustomUserDetails;
import com.korzybskiemil.localgems.car.dto.CarDto;
import com.korzybskiemil.localgems.car.dto.NewCarDto;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.korzybskiemil.localgems.auth.config.SpringSecurityConfig.USER;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RolesAllowed(USER)
    @GetMapping
    public List<CarDto> getCars() {
        return carService.getAllCars();
    }

//    @RolesAllowed(USER)
    @PostMapping
    public CarDto createNewCar(@Valid @RequestBody NewCarDto newCarDto, Authentication auth) {
        return carService.saveNewCar(newCarDto, getUserFromAuthentication(auth));
    }

    @RolesAllowed(USER)
    @PutMapping("/{id}")
    public CarDto updateCar(@PathVariable UUID id, @Valid @RequestBody NewCarDto updateCar) {
        return carService.updateCar(id, updateCar);
    }


    @RolesAllowed(USER)
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.deleteCar(id);
    }

    private static UUID getUserFromAuthentication(Authentication auth) {
        CustomUserDetails principal = (CustomUserDetails) auth.getPrincipal();
        return principal.getId();
    }
}

