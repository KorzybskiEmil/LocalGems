package com.korzybskiemil.localgems.car;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.car.common.*;
import jakarta.persistence.*;
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
    @Enumerated
    private BodyType bodyType;
    private int price;
    private int yearOfProduction;
    private int mileage;
    private int enginePower;
    private String sellerDescription;
    private String countryOfOrigin;
    private String colour;
    @Enumerated
    private TransmissionType transmissionType;
    @Enumerated
    private FuelType fuelType;
    @Enumerated
    private DriveType driveType;
    @Enumerated
    private TechnicalCondition technicalCondition;
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUser user;

}
