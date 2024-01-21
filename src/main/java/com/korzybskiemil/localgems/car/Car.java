package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.car.common.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private String brand;
    private String model;
    private BodyType bodyType;
    private int price;
    private int yearOfProduction;
    private int mileage;
    private int enginePower;
    private String sellerDescription;
    private String countryOfOrigin;
    private String colour;
    private TransmissionType transmissionType;
    private FuelType fuelType;
    private DriveType driveType;
    private TechnicalCondition technicalCondition;


}
