package com.java_tbt.api.core.validators.appointment;

import com.java_tbt.api.core.dto.appointment.AppointmentDTOCreate;

public interface BaseAppointmentValidator {
    void validate(AppointmentDTOCreate appointment);
}
