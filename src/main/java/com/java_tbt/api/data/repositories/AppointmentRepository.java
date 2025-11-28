package com.java_tbt.api.data.repositories;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java_tbt.api.core.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    boolean existsByPatientIdAndIsCancelledFalseAndDatetimeBetween(
            UUID idPatient,
            LocalDateTime startPeriod,
            LocalDateTime endPeriod);

    boolean existsByDoctorIdAndIsCancelledFalseAndDatetime(UUID idDoctor, LocalDateTime datetime);

    Page<Appointment> findAllByDoctorIdAndIsCancelledAndDatetimeBetween(
            UUID idDoctor,
            boolean isCancelled,
            LocalDateTime startPeriod,
            LocalDateTime endPeriod,
            Pageable pagination);

    Page<Appointment> findAllByPatientIdAndIsCancelledAndDatetimeBetween(
            UUID idPatient,
            boolean isCancelled,
            LocalDateTime startPeriod,
            LocalDateTime endPeriod,
            Pageable pagination);
}
