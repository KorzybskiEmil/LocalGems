package com.korzybskiemil.localgems.auth;

import com.korzybskiemil.localgems.auth.jwt.JwtTokenService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }


    @PostMapping("/login")
    public JwtTokenResponse login(@Valid @RequestBody JwtTokenRequest jwtTokenRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                jwtTokenRequest.username(), jwtTokenRequest.password()
        );
        authenticationManager.authenticate(authenticationToken);

        return new JwtTokenResponse(jwtTokenService.generateToken(jwtTokenRequest.username()));
    }
}
