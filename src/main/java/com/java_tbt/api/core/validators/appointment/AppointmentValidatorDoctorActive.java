package com.java_tbt.api.core.validators.appointment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java_tbt.api.core.dto.appointment.AppointmentDTOCreate;
import com.java_tbt.api.core.exceptions.AppointmentValidationException;
import com.java_tbt.api.data.repositories.DoctorRepository;

@Component
public class AppointmentValidatorDoctorActive implements BaseAppointmentValidator {

    @Autowired
    private DoctorRepository repository;

    @Override
    public void validate(AppointmentDTOCreate appointment) {
        if (!repository.existsByIdAndActiveTrue(UUID.fromString(appointment.idDoctor()))) {
            throw new AppointmentValidationException("This Doctor is no longer active");
        }
    }

}
