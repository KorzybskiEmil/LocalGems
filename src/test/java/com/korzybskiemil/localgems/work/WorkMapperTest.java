package com.korzybskiemil.localgems.work;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.work.common.EmploymentType;
import com.korzybskiemil.localgems.work.common.ExperienceRequired;
import com.korzybskiemil.localgems.work.common.PlaceOfWork;
import com.korzybskiemil.localgems.work.common.WorkingHours;
import com.korzybskiemil.localgems.work.dto.NewWorkDto;
import com.korzybskiemil.localgems.work.dto.WorkDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WorkMapperTest {

    public static final String RANDOM_STRING = UUID.randomUUID().toString();
    private WorkMapper workMapper;
    private ApplicationUser applicationUser;

    @BeforeEach
    void setUp() {
        workMapper = new WorkMapper();
        applicationUser = new ApplicationUser("", "");
        applicationUser.setId(UUID.randomUUID());
    }

    @Test
    void mapNewDtoToEntity() {
        //given:
        NewWorkDto newWorkDto = new NewWorkDto(
                EmploymentType.CONTRACT_OF_EMPLOYMENT,
                WorkingHours.FULL_TIME_JOB,
                ExperienceRequired.YES,
                PlaceOfWork.HOME_OFFICE,
                RANDOM_STRING,
                RANDOM_STRING,
                applicationUser.getId()
        );
        //when:
        Work work = workMapper.mapNewDtoToEntity(newWorkDto, applicationUser);
        //then:
        assertThat(work).isNotNull();
        assertThat(work).extracting(Work::getEmploymentType).isEqualTo(newWorkDto.employmentType());
        assertThat(work).extracting(Work::getWorkingHours).isEqualTo(newWorkDto.workingHours());
        assertThat(work).extracting(Work::getExperienceRequired).isEqualTo(newWorkDto.experienceRequired());
        assertThat(work).extracting(Work::getPlaceOfWork).isEqualTo(newWorkDto.placeOfWork());
        assertThat(work).extracting(Work::getCityWhereIsWork).isEqualTo(newWorkDto.cityWhereIsWork());
        assertThat(work).extracting(Work::getDescription).isEqualTo(newWorkDto.description());
    }

    @Test
    void mapEntityToDto() {
        //given:
        Work work = new Work(
                UUID.randomUUID(),
                EmploymentType.CONTRACT_OF_EMPLOYMENT,
                WorkingHours.FULL_TIME_JOB,
                ExperienceRequired.YES,
                PlaceOfWork.HOME_OFFICE,
                RANDOM_STRING,
                RANDOM_STRING,
                applicationUser
        );
        //when:
        WorkDto workDto = workMapper.mapEntityToDto(work);
        //then:
        assertThat(workDto).isNotNull();
        assertThat(workDto.id()).isEqualTo(work.getId());
        assertThat(workDto.employmentType()).isEqualTo(work.getEmploymentType());
        assertThat(workDto.workingHours()).isEqualTo(work.getWorkingHours());
        assertThat(workDto.experienceRequired()).isEqualTo(work.getExperienceRequired());
        assertThat(workDto.placeOfWork()).isEqualTo(work.getPlaceOfWork());
        assertThat(workDto.cityWhereIsWork()).isEqualTo(work.getCityWhereIsWork());
        assertThat(workDto.description()).isEqualTo(work.getDescription());
    }
}