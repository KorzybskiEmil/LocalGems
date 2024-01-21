package com.korzybskiemil.localgems.work.dto;

import com.korzybskiemil.localgems.work.common.EmploymentType;
import com.korzybskiemil.localgems.work.common.ExperienceRequired;
import com.korzybskiemil.localgems.work.common.PlaceOfWork;
import com.korzybskiemil.localgems.work.common.WorkingHours;

import java.util.UUID;

public record WorkDto(
        UUID id,
        EmploymentType employmentType,
        WorkingHours workingHours,
        ExperienceRequired experienceRequired,
        PlaceOfWork placeOfWork,
        String cityWhereIsWork,
        String description
) {
}
