package com.korzybskiemil.localgems.realestate;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.realestate.common.Floor;
import com.korzybskiemil.localgems.realestate.common.Furnitured;
import com.korzybskiemil.localgems.realestate.common.HousingType;
import com.korzybskiemil.localgems.realestate.common.SubCategory;
import com.korzybskiemil.localgems.realestate.dto.NewRealEstateDto;
import com.korzybskiemil.localgems.realestate.dto.RealEstateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RealEstateMapperTest {

    public static final String RANDOM_STRING = UUID.randomUUID().toString();
    private RealEstateMapper realEstateMapper = new RealEstateMapper();
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void mapNewDtoToEntity() {
        //given:
        NewRealEstateDto newRealEstateDto = new NewRealEstateDto(
                SubCategory.FOR_SALE,
                HousingType.APARTMENT,
                500000,
                50,
                Floor.GROUND_FLOOR,
                Furnitured.YES,
                3,
                RANDOM_STRING,
                applicationUser.getId()
        );
        //when:
        RealEstate realEstate = realEstateMapper.mapNewDtoToEntity(newRealEstateDto, applicationUser);
        //then:
        assertThat(realEstate).isNotNull();
        assertThat(realEstate).extracting(RealEstate::getSubCategory).isEqualTo(newRealEstateDto.subCategory());
        assertThat(realEstate).extracting(RealEstate::getHousingType).isEqualTo(newRealEstateDto.housingType());
        assertThat(realEstate).extracting(RealEstate::getPrice).isEqualTo(newRealEstateDto.price());
        assertThat(realEstate).extracting(RealEstate::getSurfaceArea).isEqualTo(newRealEstateDto.surfaceArea());
        assertThat(realEstate).extracting(RealEstate::getFloor).isEqualTo(newRealEstateDto.floor());
        assertThat(realEstate).extracting(RealEstate::getFurnitured).isEqualTo(newRealEstateDto.furnitured());
        assertThat(realEstate).extracting(RealEstate::getNumberOfRooms).isEqualTo(newRealEstateDto.numberOfRooms());
        assertThat(realEstate).extracting(RealEstate::getDescription).isEqualTo(newRealEstateDto.description());

    }

    @Test
    void mapEntityToDto() {
        //given:
        RealEstate realEstate = new RealEstate(
                UUID.randomUUID(),
                SubCategory.FOR_SALE,
                HousingType.APARTMENT,
                500000,
                50,
                Floor.GROUND_FLOOR,
                Furnitured.YES,
                3,
                RANDOM_STRING,
                applicationUser
        );
        //when:
        RealEstateDto realEstateDto = realEstateMapper.mapEntityToDto(realEstate);
        //then:
        assertThat(realEstateDto).isNotNull();
        assertThat(realEstateDto.id()).isEqualTo(realEstate.getId());
        assertThat(realEstateDto.subCategory()).isEqualTo(realEstate.getSubCategory());
        assertThat(realEstateDto.housingType()).isEqualTo(realEstate.getHousingType());
        assertThat(realEstateDto.price()).isEqualTo(realEstate.getPrice());
        assertThat(realEstateDto.surfaceArea()).isEqualTo(realEstate.getSurfaceArea());
        assertThat(realEstateDto.floor()).isEqualTo(realEstate.getFloor());
        assertThat(realEstateDto.furnitured()).isEqualTo(realEstate.getFurnitured());
        assertThat(realEstateDto.numberOfRooms()).isEqualTo(realEstate.getNumberOfRooms());
        assertThat(realEstateDto.description()).isEqualTo(realEstate.getDescription());
    }
}