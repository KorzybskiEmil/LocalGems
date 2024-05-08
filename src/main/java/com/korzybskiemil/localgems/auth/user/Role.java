package com.korzybskiemil.localgems.auth.user;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    @Id
    private UUID id;

    @EqualsAndHashCode.Include
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<ApplicationUser> users = new ArrayList<>();

    public void assignToUser(ApplicationUser applicationUser) {
        users.add(applicationUser);
    }
}
