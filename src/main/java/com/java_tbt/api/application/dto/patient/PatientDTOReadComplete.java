package com.java_tbt.api.application.dto.patient;

import java.util.UUID;

import com.java_tbt.api.application.dto.address.AddressDTORead;
import com.java_tbt.api.core.models.Patient;

public record PatientDTOReadComplete(
        UUID id,
        String name,
        String cpf,
        String email,
        String phone,
        AddressDTORead address,
        boolean active) {

    public PatientDTOReadComplete(Patient Patient) {
        this(Patient.getId(), Patient.getName(), Patient.getCpf(), Patient.getEmail(),
                Patient.getPhone(), new AddressDTORead(Patient.getAddress()), Patient.getActive());
    }
}
