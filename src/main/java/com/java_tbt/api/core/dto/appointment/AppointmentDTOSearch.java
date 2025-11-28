package com.java_tbt.api.core.dto.appointment;

import java.time.LocalDateTime;

public record AppointmentDTOSearch(
        String idDoctor,
        String idPatient,
        boolean isCancelled,
        LocalDateTime startPeriod,
        LocalDateTime endPeriod) {

}
