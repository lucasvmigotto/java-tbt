package com.java_tbt.api.application.dto.doctor;

import java.util.UUID;

import com.java_tbt.api.core.enums.Specialties;
import com.java_tbt.api.core.models.Doctor;

public record DoctorDTORead(
        UUID id,
        String name,
        String crm,
        Specialties specialty) {

    public DoctorDTORead(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getSpecialty());
    }

}
