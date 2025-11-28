package com.java_tbt.api.core.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.java_tbt.api.core.dto.appointment.AppointmentDTOUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Appointment")
@Table(name = "appointments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private Patient patient;

    private LocalDateTime datetime;

    private boolean isCancelled = false;

    public Appointment update(AppointmentDTOUpdate appointment) {
        if (appointment.datetime() != null) {
            datetime = appointment.datetime();
        }
        return this;
    }

    public Appointment cancel() {
        isCancelled = true;
        return this;
    }

}
