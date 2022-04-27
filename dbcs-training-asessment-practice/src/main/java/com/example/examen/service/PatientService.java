package com.example.examen.service;

import com.example.examen.dto.PatientDto;
import com.example.examen.model.Patient;
import com.example.examen.repositories.DoctorRepository;
import com.example.examen.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;
    private final DoctorRepository doctorRepository;

    public List<Patient> getAll() {
        return repository.findAll();
    }

    public Patient createPatient(PatientDto dto) {
        return repository.save(new Patient(
                dto.getName(),
                doctorRepository.getById(dto.getDoctorsName()),
                dto.getAppointments().stream()
                        .map(Date::valueOf)
                        .collect(Collectors.toList())
        ));
    }
}
