package com.java_tbt.api.application.dto.doctor;

import com.java_tbt.api.application.dto.address.AddressDTOUpdate;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DoctorDTOUpdate(
        @NotBlank String id,
        @Nullable String name,
        @Nullable @Email String email,
        @Nullable @Pattern(regexp = "\\d{13}") String phone,
        @Nullable @Valid AddressDTOUpdate address) {

}
