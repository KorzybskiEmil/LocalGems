package com.korzybskiemil.localgems.applicationuser;

import com.korzybskiemil.localgems.auth.user.Role;
import com.korzybskiemil.localgems.car.Car;
import com.korzybskiemil.localgems.gamesandconsoles.GamesAndConsoles;
import com.korzybskiemil.localgems.musicandeducation.MusicAndEducation;
import com.korzybskiemil.localgems.realestate.RealEstate;
import com.korzybskiemil.localgems.sports.Sports;
import com.korzybskiemil.localgems.variousservices.VariousServices;
import com.korzybskiemil.localgems.work.Work;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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
    @Column(unique = true)
    @EqualsAndHashCode.Include
    private String username;
    private String password;

    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<Car> carAssignedToUser;
    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<GamesAndConsoles> gamesAndConsolesAssignedToUser;
    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<MusicAndEducation> musicAndEducationAssignedToUser;
    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<RealEstate> realEstateAssignedToUser;
    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<Sports> sportsAssignedToUser;
    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<VariousServices> variousServicesAssignedToUser;
    @OneToMany(mappedBy = "applicationUser", fetch = FetchType.LAZY)
    private List<Work> workAssignedToUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "application_user_role",
            joinColumns = @JoinColumn(name = "application_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public ApplicationUser(String username, String encode) {
        this.username = username;
        this.password = encode;
    }


    public void addRole(Role role) {
        roles.add(role);
    }

}


