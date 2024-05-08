package com.korzybskiemil.localgems.musicandeducation;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.musicandeducation.common.CategoryType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MusicAndEducation {

    @Id
    @EqualsAndHashCode.Include
    UUID id;
    @Enumerated
    private CategoryType categoryType;
    private String name;
    private int price;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUser applicationUser;

}
