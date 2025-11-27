package com.java_tbt.api.core.dto.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

import com.java_tbt.api.core.models.Appointment;

public record AppointmentDTORead(
        UUID id, UUID idDoctor, UUID idPatient, LocalDateTime datetime) {
    public AppointmentDTORead(Appointment appointment) {
        this(
                appointment.getId(),
                appointment.getDoctor().getId(),
                appointment.getPatient().getId(),
                appointment.getDatetime());
    }
}
