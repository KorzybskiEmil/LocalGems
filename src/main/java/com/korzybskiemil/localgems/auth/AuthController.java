package com.korzybskiemil.localgems.auth;

import com.korzybskiemil.localgems.auth.jwt.JwtTokenService;
import com.korzybskiemil.localgems.auth.registration.AuthService;
import com.korzybskiemil.localgems.auth.registration.NewUserRegistrationDto;
import com.korzybskiemil.localgems.auth.registration.RegisteredUserDataDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final AuthService authService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.authService = authService;
    }


    @PostMapping("/login")
    public JwtTokenResponseDto login(@RequestBody JwtTokenRequestDto jwtTokenRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                jwtTokenRequest.username(), jwtTokenRequest.password()
        );
        authenticationManager.authenticate(authenticationToken);

        return new JwtTokenResponseDto(jwtTokenService.generateToken(jwtTokenRequest.username()));
    }

    @PostMapping("/register")
    public RegisteredUserDataDto registerUser(@RequestBody NewUserRegistrationDto userRegistrationDto) {
        return authService.registerNewUser(userRegistrationDto);
    }
}
