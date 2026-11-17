
package com.example.EndSem;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

    private final SecretKey secretKey;

    public JwtTokenUtil(
            @Value("${jwt.secret}") String secret) {

        this.secretKey = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    public Map<String, Object> validateToken(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims;
    }

    
    public String generateDemoToken() {

        return Jwts.builder()
                .subject("shruthi")
                .claim("email", "shruthi@gmail.com")
                .claim("destination", "Darjleenj")
                .issuedAt(new java.util.Date())
                .expiration(new java.util.Date(
                        System.currentTimeMillis() + 3600000
                ))
                .signWith(secretKey)
                .compact();
    }
}
