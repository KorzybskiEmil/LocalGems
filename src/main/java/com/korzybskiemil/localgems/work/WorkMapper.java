package com.korzybskiemil.localgems.work;

import com.korzybskiemil.localgems.work.dto.NewWorkDto;
import com.korzybskiemil.localgems.work.dto.WorkDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WorkMapper {

    public Work mapNewDtoToEntity(NewWorkDto dto) {
        return new Work(
                UUID.randomUUID(),
                dto.employmentType(),
                dto.workingHours(),
                dto.experienceRequired(),
                dto.placeOfWork(),
                dto.cityWhereIsWork(),
                dto.description()
        );
    }

    public WorkDto mapEntityToDto(Work entity) {
        return new WorkDto(
                entity.getId(),
                entity.getEmploymentType(),
                entity.getWorkingHours(),
                entity.getExperienceRequired(),
                entity.getPlaceOfWork(),
                entity.getCityWhereIsWork(),
                entity.getDescription()
        );
    }
}
