package com.korzybskiemil.localgems.work;

import com.korzybskiemil.localgems.work.common.EmploymentType;
import com.korzybskiemil.localgems.work.common.ExperienceRequired;
import com.korzybskiemil.localgems.work.common.PlaceOfWork;
import com.korzybskiemil.localgems.work.common.WorkingHours;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Work {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    @Enumerated
    private EmploymentType employmentType;
    @Enumerated
    private WorkingHours workingHours;
    @Enumerated
    private ExperienceRequired experienceRequired;
    @Enumerated
    private PlaceOfWork placeOfWork;
    private String cityWhereIsWork;
    private String description;

}
