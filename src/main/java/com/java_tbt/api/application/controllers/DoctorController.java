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

import com.java_tbt.api.application.dto.doctor.DoctorDTOCreate;
import com.java_tbt.api.application.dto.doctor.DoctorDTORead;
import com.java_tbt.api.application.dto.doctor.DoctorDTOReadComplete;
import com.java_tbt.api.application.dto.doctor.DoctorDTOUpdate;
import com.java_tbt.api.core.models.Doctor;
import com.java_tbt.api.data.repositories.DoctorRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DoctorDTORead> create(
            @RequestBody @Valid DoctorDTOCreate doctor,
            UriComponentsBuilder uriBuilder) {
        Doctor created = repository.save(new Doctor(doctor));

        return ResponseEntity
                .created(
                        uriBuilder
                                .path("/doctors/{id}")
                                .buildAndExpand(created.getId())
                                .toUri())
                .body(new DoctorDTORead(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTOReadComplete> read(@PathVariable UUID id) {
        Doctor entity = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Doctor with Id %s not found", id.toString())));
        return ResponseEntity.ok(new DoctorDTOReadComplete(entity));
    }

    @GetMapping
    public Page<DoctorDTORead> list(Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DoctorDTORead::new);
    }

    @GetMapping("/complete")
    public Page<DoctorDTOReadComplete> listComplete(Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DoctorDTOReadComplete::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DoctorDTORead> update(
            @RequestBody @Valid DoctorDTOUpdate doctor,
            UriComponentsBuilder uriBuilder) {
        Doctor entity = repository
                .findById(UUID.fromString(doctor.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Doctor with Id %s not found", doctor.id())))
                .update(doctor);

        Doctor updated = repository.save(entity);

        return ResponseEntity.ok(new DoctorDTORead(updated));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        Doctor entity = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Doctor with Id %s not found", id.toString())))
                .delete();

        repository.save(entity);

        return ResponseEntity.noContent().build();
    }

}
