package com.java_tbt.api.application.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.java_tbt.api.application.dto.patient.PatientDTOCreate;
import com.java_tbt.api.application.dto.patient.PatientDTORead;
import com.java_tbt.api.application.dto.patient.PatientDTOReadComplete;
import com.java_tbt.api.application.dto.patient.PatientDTOUpdate;
import com.java_tbt.api.core.models.Patient;
import com.java_tbt.api.data.repositories.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDTORead> create(
            @RequestBody @Valid PatientDTOCreate patient,
            UriComponentsBuilder uriBuilder) {
        Patient created = repository.save(new Patient(patient));

        return ResponseEntity
                .created(
                        uriBuilder
                                .path("/patients/{id}")
                                .buildAndExpand(created.getId())
                                .toUri())
                .body(new PatientDTORead(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTOReadComplete> read(@PathVariable UUID id) {
        Patient entity = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Patient with Id %s not found", id.toString())));
        return ResponseEntity.ok(new PatientDTOReadComplete(entity));
    }

    @GetMapping
    public Page<PatientDTORead> list(Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(PatientDTORead::new);
    }

    @GetMapping("/complete")
    public Page<PatientDTOReadComplete> listComplete(Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(PatientDTOReadComplete::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PatientDTORead> update(
            @RequestBody @Valid PatientDTOUpdate patient,
            UriComponentsBuilder uriBuilder) {
        Patient entity = repository
                .findById(UUID.fromString(patient.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Patient with Id %s not found", patient.id())))
                .update(patient);

        Patient updated = repository.save(entity);

        return ResponseEntity.ok(new PatientDTORead(updated));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        Patient entity = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Patient with Id %s not found", id.toString())))
                .delete();

        repository.save(entity);

        return ResponseEntity.noContent().build();
    }

}
