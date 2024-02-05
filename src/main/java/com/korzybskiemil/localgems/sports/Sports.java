package com.korzybskiemil.localgems.sports;

import com.korzybskiemil.localgems.sports.common.ItemCondition;
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
public class Sports {

    @Id
    @EqualsAndHashCode.Include
    UUID id;
    private String name;
    private int price;
    @Enumerated
    private ItemCondition condition;
    private String description;
}
