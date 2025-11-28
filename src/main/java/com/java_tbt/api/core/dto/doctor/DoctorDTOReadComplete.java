package com.java_tbt.api.core.dto.doctor;

import java.util.UUID;

import com.java_tbt.api.core.dto.address.AddressDTORead;
import com.java_tbt.api.core.enums.Specialties;
import com.java_tbt.api.core.models.Doctor;

public record DoctorDTOReadComplete(
        UUID id,
        String name,
        String crm,
        Specialties specialty,
        String email,
        String phone,
        AddressDTORead address,
        boolean active) {

    public DoctorDTOReadComplete(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getSpecialty(), doctor.getEmail(),
                doctor.getPhone(), new AddressDTORead(doctor.getAddress()), doctor.getActive());
    }
}
