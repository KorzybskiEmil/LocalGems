package com.korzybskiemil.localgems.gamesandconsoles;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.gamesandconsoles.common.Platform;
import com.korzybskiemil.localgems.gamesandconsoles.common.SubCategory;
import com.korzybskiemil.localgems.gamesandconsoles.common.TechnicalCondition;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class GamesAndConsoles {

    @Id
    @EqualsAndHashCode.Include
    UUID id;
    String name;
    @Enumerated
    private SubCategory subCategory;
    @Enumerated
    private Platform platform;
    private int price;
    @Enumerated
    private TechnicalCondition technicalCondition;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUser user;

}
