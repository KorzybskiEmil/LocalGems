package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.variousservices.common.ServiceOptions;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VariousServices {

    @Id
    @EqualsAndHashCode.Include
    UUID id;
    @Enumerated
    private ServiceOptions serviceOptions;
    String description;
    int pricePerHour;

}
