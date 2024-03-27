package com.korzybskiemil.localgems.auth.registration;

import com.korzybskiemil.localgems.auth.config.SpringSecurityConfig;
import com.korzybskiemil.localgems.auth.user.Role;
import com.korzybskiemil.localgems.auth.user.RoleRepository;
import com.korzybskiemil.localgems.auth.user.User;
import com.korzybskiemil.localgems.auth.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public RegisteredUserDataDto registerNewUser(NewUserRegistrationDto registrationDto) {
        verifyUserEmail(registrationDto);

        User newUser = new User(
                registrationDto.username(),
                passwordEncoder.encode(registrationDto.password())
        );

        newUser.setId(UUID.randomUUID());

        Role userRole = roleRepository.findByName(SpringSecurityConfig.USER)
                .orElseThrow(() -> new IllegalStateException("Expected user role in database"));

        newUser.addRole(userRole);
        userRole.assignToUser(newUser);

        User savedUser = userRepository.save(newUser);

        return new RegisteredUserDataDto(savedUser.getId(), savedUser.getEmail());
    }

    //TODO problem z exception handlingiem
    private void verifyUserEmail(NewUserRegistrationDto registrationDto) {
        userRepository.findByEmail(registrationDto.username());
    }
}
