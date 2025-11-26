package com.java_tbt.api.data.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java_tbt.api.core.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    Page<Patient> findAllByActiveTrue(Pageable pagination);
}
