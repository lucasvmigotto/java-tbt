package com.java_tbt.api.data.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java_tbt.api.core.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Page<Doctor> findAllByActiveTrue(Pageable pagination);

    Doctor findByIdAndActiveTrue(UUID id);

    boolean existsByIdAndActiveTrue(UUID id);
}
