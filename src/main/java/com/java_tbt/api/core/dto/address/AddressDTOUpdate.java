package com.java_tbt.api.core.dto.address;

import java.util.OptionalInt;

import jakarta.validation.constraints.Pattern;

public record AddressDTOUpdate(
                String firstLine,
                String secondLine,
                OptionalInt number,
                @Pattern(regexp = "\\d{8}") String zipCode,
                String complement) {

}
