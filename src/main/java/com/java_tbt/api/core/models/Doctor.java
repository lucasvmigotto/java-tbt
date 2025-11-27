package com.java_tbt.api.core.models;

import java.util.UUID;

import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

import com.java_tbt.api.core.dto.doctor.DoctorDTOCreate;
import com.java_tbt.api.core.dto.doctor.DoctorDTOUpdate;
import com.java_tbt.api.core.enums.Specialties;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Doctor")
@Table(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String crm;

    private String email;

    @Enumerated(EnumType.STRING)
    @JdbcType(value = PostgreSQLEnumJdbcType.class)
    private Specialties specialty;

    private String phone;

    private Boolean active = true;

    @Embedded
    private Address address;

    public Doctor(DoctorDTOCreate doctor) {
        name = doctor.name();
        crm = doctor.crm();
        email = doctor.email();
        specialty = doctor.specialty();
        phone = doctor.phone();
        address = new Address(doctor.address());
    }

    public Doctor update(DoctorDTOUpdate doctor) {
        if (doctor.name() != null) {
            name = doctor.name();
        }
        if (doctor.email() != null) {
            email = doctor.email();
        }
        if (doctor.phone() != null) {
            phone = doctor.phone();
        }
        if (doctor.address() != null) {
            address = address.update(doctor.address());
        }
        return this;
    }

    public Doctor delete() {
        active = false;
        return this;
    }

}
