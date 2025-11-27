package com.java_tbt.api.core.validators.appointment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java_tbt.api.core.dto.appointment.AppointmentDTOCreate;
import com.java_tbt.api.core.exceptions.AppointmentValidationException;
import com.java_tbt.api.data.repositories.AppointmentRepository;

@Component
public class AppointmentValidatorDoctorHasAvailability implements BaseAppointmentValidator {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public void validate(AppointmentDTOCreate appointment) {
        if (repository.existsByDoctorIdAndIsCancelledFalseAndDatetime(
                UUID.fromString(appointment.idDoctor()),
                appointment.datetime())) {
            throw new AppointmentValidationException("This Doctor do not have availability");
        }
    }

}
