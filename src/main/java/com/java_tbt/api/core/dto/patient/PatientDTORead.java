package com.java_tbt.api.core.dto.patient;

import java.util.UUID;

import com.java_tbt.api.core.models.Patient;

public record PatientDTORead(
        UUID id,
        String name,
        String cpf,
        String email) {

    public PatientDTORead(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getCpf(), patient.getEmail());
    }

}
