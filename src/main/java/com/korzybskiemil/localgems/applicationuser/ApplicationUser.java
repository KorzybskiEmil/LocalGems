package com.korzybskiemil.localgems.applicationuser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {

    @Id
    UUID id;
    @NotBlank
    @Column(unique = true)
    private String nickname;
    @NotBlank
    @Column(unique = true)
    @EqualsAndHashCode.Include
    private String email;
    @NotBlank
    private String password;
}
