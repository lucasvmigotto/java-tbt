package com.java_tbt.api.core.dto.auth;

import java.util.UUID;

import com.java_tbt.api.core.models.User;

public record AuthDTORead(UUID id, String username) {
    public AuthDTORead(User user) {
        this(user.getId(), user.getUsername());
    }
}
