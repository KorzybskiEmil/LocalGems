package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.car.dto.CarDto;
import com.korzybskiemil.localgems.car.dto.NewCarDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> getCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public CarDto createNewDeveloper(@Valid @RequestBody NewCarDto newCarDto) {
        return carService.saveNewCar(newCarDto);
    }

    @PutMapping("/{id}")
    public CarDto updateCar(@PathVariable UUID id, @Valid @RequestBody NewCarDto updateCar) {
        return carService.updateCar(id, updateCar);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.deleteCar(id);
    }
}
