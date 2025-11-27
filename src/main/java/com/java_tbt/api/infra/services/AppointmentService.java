package com.java_tbt.api.infra.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_tbt.api.core.dto.appointment.AppointmentDTOCreate;
import com.java_tbt.api.core.dto.appointment.AppointmentDTORead;
import com.java_tbt.api.core.exceptions.AppointmentValidationException;
import com.java_tbt.api.core.models.Appointment;
import com.java_tbt.api.core.models.Doctor;
import com.java_tbt.api.core.models.Patient;
import com.java_tbt.api.core.validators.appointment.BaseAppointmentValidator;
import com.java_tbt.api.data.repositories.AppointmentRepository;
import com.java_tbt.api.data.repositories.DoctorRepository;
import com.java_tbt.api.data.repositories.PatientRepository;

@Service
public class AppointmentService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private List<BaseAppointmentValidator> appointmentValidators;

    public AppointmentDTORead schedule(AppointmentDTOCreate appointment) {
        Patient patient = patientRepository.findByIdAndActiveTrue(UUID.fromString(appointment.idPatient()));
        if (patient == null) {
            throw new AppointmentValidationException("Patient does not exists");
        }
        Doctor doctor = doctorRepository.findByIdAndActiveTrue(UUID.fromString(appointment.idDoctor()));
        if (doctor == null) {
            throw new AppointmentValidationException("Doctor does not exists");
        }

        appointmentValidators.forEach(validator -> validator.validate(appointment));

        Appointment created = appointmentRepository
                .save(new Appointment(null, doctor, patient, appointment.datetime(), false));

        return new AppointmentDTORead(created.getId(), doctor.getId(), patient.getId(), created.getDatetime());

    }

}
