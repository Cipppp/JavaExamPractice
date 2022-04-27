package com.example.examen.model;

import com.example.examen.observer.PatientObserver;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Getter
@Setter
public class Doctor {
    public Doctor() {
        patientObserver = new PatientObserver();
        patientObserver.subscribe(this);
    }

    @Id
    String name;

    String specialty;

    @OneToMany
    List<Patient> patients;

    public void addPatient(Patient patient) {
        patients.add(patient);
        patientObserver.update(patient);
    }

    public void newPatientNotify(Patient patient) {
        System.out.println("Mail pacient nou :" + patient.getName());
    }

    @Transient
    PatientObserver patientObserver;

}
