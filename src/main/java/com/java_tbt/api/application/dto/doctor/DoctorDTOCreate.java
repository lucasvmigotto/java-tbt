package com.java_tbt.api.application.dto.doctor;

import com.java_tbt.api.application.dto.address.AddressDTOCreate;
import com.java_tbt.api.core.enums.Specialties;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorDTOCreate(
        @NotBlank String name,
        @NotBlank @Pattern(regexp = "\\d{6}") String crm,
        @NotBlank @Email String email,
        @NotNull Specialties specialty,
        @NotBlank @Pattern(regexp = "\\d{13}") String phone,
        @NotNull @Valid AddressDTOCreate address) {

}
