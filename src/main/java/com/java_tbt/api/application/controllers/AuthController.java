package com.java_tbt.api.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_tbt.api.core.dto.auth.AuthDTOLogin;
import com.java_tbt.api.core.dto.auth.AuthDTOToken;
import com.java_tbt.api.core.models.User;
import com.java_tbt.api.infra.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {

        @Autowired
        private TokenService tokenService;

        @Autowired
        private AuthenticationManager authManager;

        @PostMapping
        @Transactional
        public ResponseEntity<AuthDTOToken> login(
                        @RequestBody @Valid AuthDTOLogin auth) {
                System.out.println("dd");
                String token = tokenService.generateToken(
                                (User) authManager
                                                .authenticate(
                                                                new UsernamePasswordAuthenticationToken(auth.username(),
                                                                                auth.password()))
                                                .getPrincipal());

                return ResponseEntity
                                .ok(new AuthDTOToken(token));
        }

}
