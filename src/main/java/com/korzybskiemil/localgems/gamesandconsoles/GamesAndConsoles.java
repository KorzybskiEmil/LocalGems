package com.korzybskiemil.localgems.gamesandconsoles;

import com.korzybskiemil.localgems.gamesandconsoles.common.Platform;
import com.korzybskiemil.localgems.gamesandconsoles.common.SubCategory;
import com.korzybskiemil.localgems.gamesandconsoles.common.TechnicalCondition;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
    private Platform platform;
    private int price;
    @Enumerated
    private TechnicalCondition technicalCondition;
    private String description;

}
