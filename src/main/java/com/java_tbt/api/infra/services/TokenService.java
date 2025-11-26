package com.java_tbt.api.infra.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.java_tbt.api.core.models.User;

@Service
public class TokenService {

    @Value("${api.jwt.secret}")
    private String secret;

    @Value("${api.jwt.issuer}")
    private String issuer;

    @Value("${api.jwt.expires}")
    private long expires;

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

    private Instant tokenExpires(long hours) {
        return LocalDateTime.now().plusHours(hours).toInstant(ZoneOffset.UTC);
    }

    public String generateToken(User user) {
        try {
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getUsername())
                    .withExpiresAt(tokenExpires(expires))
                    .sign(getAlgorithm());
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating JWT Token", exception);
        }
    }

    public String getSubject(String token) {
        try {
            return JWT.require(getAlgorithm())
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid or malformed JWT Token", exception);
        }
    }

}
