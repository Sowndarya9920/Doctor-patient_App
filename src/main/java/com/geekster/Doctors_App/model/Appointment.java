package com.geekster.Doctors_App.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

    @Id
    @EmbeddedId
    private AppointmentKey appointmentKey;

    @ManyToOne
    @JoinColumn(name = "FK_doctor_id")
    private Doctor doctor;

    @OneToOne
    private Patient patient;
}


