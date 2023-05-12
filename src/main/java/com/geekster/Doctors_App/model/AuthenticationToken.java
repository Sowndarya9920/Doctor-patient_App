package com.geekster.Doctors_App.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreatedDate;

    @OneToOne()
    @JoinColumn(name = "FK_patientId",nullable = false)
    private Patient patient;
    public AuthenticationToken(Patient patient) {
        this.patient = patient;
        this.tokenCreatedDate=LocalDate.now();
        this.token= UUID.randomUUID().toString();
    }
}
