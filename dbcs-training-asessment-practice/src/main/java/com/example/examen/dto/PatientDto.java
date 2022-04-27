package com.example.examen.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class PatientDto {
    private String name;
    private String doctorsName;

    private List<String> appointments;
}
