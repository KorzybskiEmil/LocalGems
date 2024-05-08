package com.korzybskiemil.localgems.auth.registration;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserRepository;
import com.korzybskiemil.localgems.applicationuser.dto.ApplicationUserDto;
import com.korzybskiemil.localgems.applicationuser.dto.NewApplicationUserDto;
import com.korzybskiemil.localgems.auth.config.SpringSecurityConfig;
import com.korzybskiemil.localgems.auth.user.Role;
import com.korzybskiemil.localgems.auth.user.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ApplicationUserRepository applicationUserRepository;

    public AuthService(PasswordEncoder passwordEncoder, RoleRepository roleRepository, ApplicationUserRepository applicationUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Transactional
    public ApplicationUserDto registerNewUser(NewApplicationUserDto registrationDto) {
//        verifyUserEmail(registrationDto);

        ApplicationUser newUser = new ApplicationUser(
                registrationDto.username(),
                passwordEncoder.encode(registrationDto.password())
        );

        newUser.setId(UUID.randomUUID());

        Role userRole = roleRepository.findByName(SpringSecurityConfig.USER)
                .orElseThrow(() -> new IllegalStateException("Expected user role in database"));

        newUser.addRole(userRole);
        userRole.assignToUser(newUser);

        ApplicationUser savedUser = applicationUserRepository.save(newUser);

        return new ApplicationUserDto(savedUser.getId(), savedUser.getUsername());
    }

//    //TODO exception handling
//    private void verifyUserEmail(NewUserRegistrationDto registrationDto) {
//        applicationUserRepository.findByUsername(registrationDto.username());
//    }
}
