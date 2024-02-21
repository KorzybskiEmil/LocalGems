package com.korzybskiemil.localgems.auth.config;

import com.korzybskiemil.localgems.auth.jwt.JwtRequestFilter;
import com.korzybskiemil.localgems.auth.jwt.JwtTokenService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableConfigurationProperties(AuthConfigProperties.class)
@EnableMethodSecurity(jsr250Enabled = true)
@SecurityScheme(
        name = "jwtauth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "jwt",
        scheme = "bearer"
)
@OpenAPIDefinition(security = {@SecurityRequirement(name = "jwtauth")})
public class SpringSecurityConfig {

    private static String[] URL_WHITELIST = {"/api/v1/register", "/api/v1/login", "/swagger-ui/**", "/v3/api-docs/**", "/error"};
    public static final String USER_WRITE = "USER_WRITE";
    public static final String USER_READ = "USER_READ";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationEntryPoint authenticationEntryPoint, JwtRequestFilter jwtRequestFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(URL_WHITELIST).permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(eh -> eh.authenticationEntryPoint(authenticationEntryPoint))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("mailzdupy@mail.com")
                .password(passwordEncoder().encode("1241t112t"))
                .roles(USER_READ, USER_WRITE)
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtTokenService jwtTokenService(AuthConfigProperties authConfigProperties) {
        return new JwtTokenService(authConfigProperties);
    }

    @Bean
    public JwtRequestFilter jwtRequestFilter(UserDetailsService userDetailsService, JwtTokenService jwtTokenService) {
        return new JwtRequestFilter(jwtTokenService, userDetailsService);
    }
}
