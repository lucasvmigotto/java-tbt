package com.java_tbt.api.core.models;

import java.util.UUID;

import com.java_tbt.api.application.dto.patient.PatientDTOCreate;
import com.java_tbt.api.application.dto.patient.PatientDTOUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Patient")
@Table(name = "patients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String cpf;
    private String email;
    private String phone;
    private Boolean active = true;
    @Embedded
    private Address address;

    public Patient(PatientDTOCreate patient) {
        name = patient.name();
        cpf = patient.cpf();
        email = patient.email();
        phone = patient.phone();
        address = new Address(patient.address());
    }

    public Patient update(PatientDTOUpdate patient) {
        if (patient.name() != null) {
            name = patient.name();
        }
        if (patient.email() != null) {
            email = patient.email();
        }
        if (patient.phone() != null) {
            phone = patient.phone();
        }
        if (patient.address() != null) {
            address = address.update(patient.address());
        }
        return this;
    }

    public Patient delete() {
        active = false;
        return this;
    }

}
