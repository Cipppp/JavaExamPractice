package com.example.examen.observer;

import com.example.examen.model.Doctor;
import com.example.examen.model.Patient;

public class PatientObserver {
    Doctor doctor;

    public void subscribe(Doctor doctor) {
        this.doctor = doctor;
    }


    public void update(Patient patient) {
        if(doctor != null) {
            doctor.newPatientNotify(patient);
        }
    }
}
