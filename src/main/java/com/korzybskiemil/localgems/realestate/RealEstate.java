package com.korzybskiemil.localgems.realestate;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.realestate.common.Floor;
import com.korzybskiemil.localgems.realestate.common.Furnitured;
import com.korzybskiemil.localgems.realestate.common.HousingType;
import com.korzybskiemil.localgems.realestate.common.SubCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class RealEstate {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    @Enumerated
    private SubCategory subCategory;
    @Enumerated
    private HousingType housingType;
    private int price;
    private int surfaceArea;
    @Enumerated
    private Floor floor;
    @Enumerated
    private Furnitured furnitured;
    private int numberOfRooms;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUser user;

}
