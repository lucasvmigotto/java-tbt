package com.java_tbt.api.core.dto.appointment;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record AppointmentDTOUpdate(
                @NotBlank String id, @Future LocalDateTime datetime) {

}
