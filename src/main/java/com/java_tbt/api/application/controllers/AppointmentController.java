package com.java_tbt.api.application.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_tbt.api.core.dto.appointment.AppointmentDTOCreate;
import com.java_tbt.api.core.dto.appointment.AppointmentDTORead;
import com.java_tbt.api.core.models.Appointment;
import com.java_tbt.api.data.repositories.AppointmentRepository;
import com.java_tbt.api.infra.services.AppointmentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("appointments")
@SecurityRequirement(name = "bearer-key")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @Autowired
    private AppointmentRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<AppointmentDTORead> schedule(@RequestBody AppointmentDTOCreate appointment) {
        AppointmentDTORead scheduled = service.schedule(appointment);

        return ResponseEntity.ok(scheduled);
    }

    @PatchMapping("/{id}")

    @Transactional
    public ResponseEntity<Void> cancel(@PathVariable UUID id) {
        Appointment entity = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Appointment with Id %s not found", id.toString())))
                .cancel();

        repository.save(entity);

        return ResponseEntity.noContent().build();
    }

}
