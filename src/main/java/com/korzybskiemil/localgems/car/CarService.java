package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.car.dto.CarDto;
import com.korzybskiemil.localgems.car.dto.NewCarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public CarDto saveNewCar (NewCarDto newCarDto) {
        Car savedCar = carRepository.save(carMapper.mapNewDtoToEntity(newCarDto));
        return carMapper.mapEntityToDto(savedCar);
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(carMapper::mapEntityToDto)
                .toList();
    }

    public CarDto updateCar(UUID id, NewCarDto updatedCarDto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> getCarNotFoundException(id));

        car.setBrand(updatedCarDto.brand());
        car.setModel(updatedCarDto.model());
        car.setBodyType(updatedCarDto.bodyType());
        car.setPrice(updatedCarDto.price());
        car.setYearOfProduction(updatedCarDto.yearOfProduction());
        car.setMileage(updatedCarDto.mileage());
        car.setEnginePower(updatedCarDto.enginePower());
        car.setSellerDescription(updatedCarDto.sellerDescription());
        car.setCountryOfOrigin(updatedCarDto.countryOfOrigin());
        car.setColour(updatedCarDto.colour());
        car.setTransmissionType(updatedCarDto.transmissionType());
        car.setFuelType(updatedCarDto.fuelType());
        car.setDriveType(updatedCarDto.driveType());
        car.setTechnicalCondition(updatedCarDto.technicalCondition());

        Car save = carRepository.save(car);
        return carMapper.mapEntityToDto(save);
    }

    public void deleteCar(UUID id) {
        carRepository.findById(id)
                .orElseThrow(() -> getCarNotFoundException(id));

        carRepository.deleteById(id);
    }

    private CarNotFoundException getCarNotFoundException(UUID id) {
        return new CarNotFoundException("Car with id: " + id + " does not exist");
    }
}
