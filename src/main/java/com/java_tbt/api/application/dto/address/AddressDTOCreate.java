package com.java_tbt.api.application.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressDTOCreate(
        @NotBlank String firstLine,
        String secondLine,
        @NotNull int number,
        @NotBlank @Pattern(regexp = "\\d{8}") String zipCode,
        String complement) {

}
