package com.example.examen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    public Patient(String name, Doctor doctor, List<Date> appointments) {
        this.name = name;
        this.doctor = doctor;
        this.appointments = appointments;
    }

    @Id
    private String name;

    @ManyToOne
    private Doctor doctor;

    @ElementCollection
    @CollectionTable(name = "appointments")
    private List<Date> appointments;
}
