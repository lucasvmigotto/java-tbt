package com.java_tbt.api.core.dto.patient;

import com.java_tbt.api.core.dto.address.AddressDTOCreate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientDTOCreate(
                @NotBlank String name,
                @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
                @NotBlank @Pattern(regexp = "\\d{13}") String phone,
                @NotBlank @Email String email,
                @NotNull @Valid AddressDTOCreate address) {

}
