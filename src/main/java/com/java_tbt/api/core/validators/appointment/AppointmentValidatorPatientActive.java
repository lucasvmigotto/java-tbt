package com.java_tbt.api.core.validators.appointment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java_tbt.api.core.dto.appointment.AppointmentDTOCreate;
import com.java_tbt.api.core.exceptions.AppointmentValidationException;
import com.java_tbt.api.data.repositories.PatientRepository;

@Component
public class AppointmentValidatorPatientActive implements BaseAppointmentValidator {

    @Autowired
    private PatientRepository repository;

    @Override
    public void validate(AppointmentDTOCreate appointment) {
        if (!repository.existsByIdAndActiveTrue(UUID.fromString(appointment.idPatient()))) {
            throw new AppointmentValidationException("This Patient is no longer active");
        }
    }

}
