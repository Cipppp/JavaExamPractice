package com.example.examen.service;

import com.example.examen.exceptions.DoctorNotFoundException;
import com.example.examen.exceptions.EmptySpecialtyFilterException;
import com.example.examen.model.Doctor;
import com.example.examen.model.Patient;
import com.example.examen.repositories.DoctorRepository;
import com.example.examen.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repository;
    private final PatientRepository patientRepository;
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    public List<Doctor> getAllBySpecialty(String specialty) throws EmptySpecialtyFilterException{
        List<Doctor> doctors = repository.findAll().stream()
                .filter(x -> x.getSpecialty().equals(specialty))
                .collect(Collectors.toList());
        if(doctors.size() == 0)
            throw new EmptySpecialtyFilterException("Nu sunt medici cu aceasta specializare");
        else return doctors;
    }

    public Doctor addPatient(String doctorName, Patient patient) throws DoctorNotFoundException{
        Optional<Doctor> doctorOptional = repository.findById(doctorName);
        if(doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            doctor.addPatient(patient);
            return repository.save(doctor);
        }
        else {
            throw new DoctorNotFoundException("Nu a fost gasit doctorul cu numele " + doctorName);
        }
    }
}
