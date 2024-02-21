package com.korzybskiemil.localgems.auth.jwt;

import com.korzybskiemil.localgems.auth.config.AuthConfigProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenService {

    private final AuthConfigProperties authConfigProperties;

    public JwtTokenService(AuthConfigProperties authConfigProperties) {
        this.authConfigProperties = authConfigProperties;
    }
    public boolean validateToken(String jwtToken, String springUserName) {
        String jwtUserName = getUserNameFromToken(jwtToken);
        boolean isExpired = getExpirationFromToken(jwtToken).before(new Date());
        return !isExpired && jwtUserName.equals(springUserName);
    }

    public String getUserNameFromToken(String jwtToken) {
        return getClaims(jwtToken).getSubject();
    }

    public Date getExpirationFromToken(String jwtToken) {
        return getClaims(jwtToken).getExpiration();
    }

    private Claims getClaims(String jwtToken) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(authConfigProperties.secret().getBytes());
    }
}
