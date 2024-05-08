package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.variousservices.common.ServiceOptions;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUser applicationUser;

}
